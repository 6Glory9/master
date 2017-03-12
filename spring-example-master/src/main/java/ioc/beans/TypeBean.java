package ioc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by jxilong on 2016/3/20.
 */
public class TypeBean<T> {

	private T t;

	public TypeBean() {
	}

	public <M> TypeBean(T t) {
		this.t = t;
	}

	public static <E> E parameterizedtypes(ArrayList<ArrayList<Integer>> al1, ArrayList<E> al2, ArrayList<String> al3,
										   ArrayList<? extends Number> al4, ArrayList<E[]> al5) {
		return null;
	}
	
	public static <E> E genericArrayTypes(	String[] p1, E[] p2, ArrayList<E>[] p3, E[][] p4, Object[][] p5,
											ArrayList<? extends Number>[] p6, ArrayList<String>[] p7) {
		return null;
	}
	
	public static <E extends Map<String, Date> & Cloneable & Serializable> E typeVariables(E e) {
		
		return null;
	}
	
	public static <E> void wildcardType(ArrayList<? extends E> al) {
	
	}
	
}
