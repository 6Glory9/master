package typeHandlers;

import com.yjf.common.lang.util.money.Money;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 处理money转换 <h3>Example</h3> 在mapper配置文件中配置列:
 * 
 * <pre>
 *     {@code
 *      <result column="single_max_amount" property="singleMaxAmount" jdbcType="DECIMAL" typeHandler="com.yjf.common.mybatis.MoneyTypeHandler" />
 *     }
 *
 * </pre>
 *
 * @author qzhanbo@yiji.com
 */
@MappedTypes(Money.class)
@MappedJdbcTypes({ JdbcType.BIGINT })
public class MoneyTypeHandler extends BaseTypeHandler<Money> {
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Money parameter, JdbcType jdbcType)
																									throws SQLException {
		ps.setLong(i, parameter.getCent());
	}
	
	@Override
	public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
		long result = rs.getLong(columnName);
		Money money = new Money();
		money.setCent(result);
		return money;
	}
	
	@Override
	public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		long result = rs.getLong(columnIndex);
		Money money = new Money();
		money.setCent(result);
		return money;
	}
	
	@Override
	public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		long result = cs.getLong(columnIndex);
		Money money = new Money();
		money.setCent(result);
		return money;
	}
	
}
