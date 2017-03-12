/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-18 23:31 创建
 *
 */
package hibernate.xml.basictype;

import com.yjf.common.lang.util.money.Money;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author jxilong@yiji.com
 */
public class MoneyType implements UserType {
	
	/**
	 * 返回UserType所映射字段的SQL类型（java.sql.Types) 返回类型为int[]，其中包含了映射个字段的SQL类型代码
	 * (UserType可以映射到一个或者多个字段)
	 * @return
	 */
	@Override
	public int[] sqlTypes() {
		return new int[] { Types.BIGINT };
	}
	
	/**
	 * UserType.nullSafeGet()所返回的自定义数据类型
	 * @return
	 */
	
	@Override
	public Class returnedClass() {
		return Money.class;
	}
	
	/**
	 * 自定义数据类型的比对方法 此方法将用作脏数据检查，参数x、y分别为数据的两个副本
	 * 如果equals方法返回false,则Hibernate将认为数据发生变化,并将变化更新到数据库表中
	 * @param x
	 * @param y
	 * @return
	 * @throws HibernateException
	 */
	
	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x.equals(y);
	}
	
	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}
	
	/**
	 * 从JDBC ResultSet读取数据,将其转换为自定义类型后返回 (此方法要求对克能出现null值进行处理)
	 * names中包含了当前自定义类型的映射字段名称
	 * @param rs
	 * @param names
	 * @param owner
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 */
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
																										throws HibernateException,
																										SQLException {
		Long moneyCent = rs.getLong(names[0]);
		if (moneyCent == null) {
			return null;
		} else {
			return new Money(moneyCent);
		}
		
	}
	
	/**
	 * 本方法将在Hibernate进行数据保存时被调用 我们可以通过PreparedStateme将自定义数据写入到对应的数据库表字段
	 * @param st
	 * @param value
	 * @param index
	 * @throws HibernateException
	 * @throws SQLException
	 */
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
																										throws HibernateException,
																										SQLException {
		if (value != null) {
			Money money = (Money) value;
			st.setLong(index, money.getCent());
		}
	}
	
	/**
	 * 提供自定义类型的完全复制方法 本方法将用构造返回对象 当nullSafeGet方法调用之后，我们获得了自定义数据对象，在向用户返回自定义数据之前，
	 * deepCopy方法将被调用，它将根据自定义数据对象构造一个完全拷贝，并将此拷贝返回给用户
	 * 此时我们就得到了自定义数据对象的两个版本，第一个是从数据库读出的原始版本，其二是我们通过
	 * deepCopy方法构造的复制版本，原始的版本将有Hibernate维护，复制版由用户使用。原始版本用作
	 * 稍后的脏数据检查依据；Hibernate将在脏数据检查过程中将两个版本的数据进行对比（通过调用
	 * equals方法），如果数据发生了变化（equals方法返回false），则执行对应的持久化操作
	 *
	 * @param value
	 * @return
	 * @throws HibernateException
	 */
	@Override
	public Object deepCopy(Object value) throws HibernateException {
		Money oldMoney = (Money) value;
		return new Money(oldMoney.getAmount());
	}
	
	/**
	 * 本类型实例是否可变
	 * @return
	 */
	@Override
	public boolean isMutable() {
		return false;
	}
	
	/**
	 * 序列化
	 * @param value
	 * @return
	 * @throws HibernateException
	 */
	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return null;
	}
	
	/**
	 * 反序列化
	 * @param cached
	 * @param owner
	 * @return
	 * @throws HibernateException
	 */
	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return null;
	}
	
	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return null;
	}
}
