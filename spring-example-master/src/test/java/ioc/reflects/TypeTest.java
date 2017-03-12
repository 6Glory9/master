package ioc.reflects;

import base.BaseTest;
import ioc.beans.TypeBean;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Created by jxilong on 2016/3/20.
 * <p>
 * Type直接子接口
 * 1.ParameterizedType:表示一种参数化的类型，比如Collection<String>
 * 2.GenericArrayType:表示一种元素类型是参数化类型或者类型变量的数组类型
 * 3. TypeVariable: 是各种类型变量的公共父接口
 * 4.WildcardType:代表一种通配符类型表达式 比如?, ? extends Number, ? superInteger【wildcard是一个单词：就是“通配符”】
 * 5.Class 直接实现类
 * GenericDeclaration表示泛型所在位置class,method,Constructor
 * </p>
 * <p>
 * address:http://blog.csdn.net/benjaminzhang666/article/details/9838937
 * <p>
 * Type所有类型指代的有：原始类型 (raw types)【对应Class】， 参数化类型
 * (parameterizedtypes)【对应ParameterizedType】， 数组类型
 * (arraytypes)【对应GenericArrayType】， 类型变量 (typevariables)【对应TypeVariable】，
 * 基本数据类型(primitivetypes)【仍然对应Class】
 */
public class TypeTest extends BaseTest {
	
	private Class typeBeanClass = TypeBean.class;

	/**
	 * 当是<>,我们用的ParameterizedTypeImpl表达Type的类型
	 *
	 *
	 */
	@Test
	public void testParameterizedtypes() {
		parseMehthodParamters("parameterizedtypes");
	}


	/**
	 *
	 *E[],List<String>[],List<? extends String> GenericArrayTypeImpl
	 *
	 *Object[],Object[][]  class
	 */
	@Test
	public void testGenericArrayTypes() {
		parseMehthodParamters("genericArrayTypes");
	}

	/**
	 * E  TypeVariableImpl
	 */
	@Test
	public void testTypeVariables() {
		parseMehthodParamters("typeVariables");
	}

	/**
	 * ? extends E 间接的类型 WildcardTypeImpl
	 */
	@Test
	public void testWildcardType() {
		Type[] typeArray = getTypes("wildcardType");
		for (Type type : typeArray) {
			logger.info("type of 【{}】", type);
			logger.info("class of 【{}】", type.getClass());
			printBoundary();
			
			if (type instanceof ParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType) type;
				
				for (Type wiType : parameterizedType.getActualTypeArguments()) {
					logger.info("type of 【{}】", wiType);
					logger.info("class of 【{}】", wiType.getClass());
					if (wiType instanceof WildcardType) {
						WildcardType wildcardType = (WildcardType) wiType;
						logger.info("getUpperBounds of 【{}】", wildcardType.getUpperBounds());
						logger.info("getLowerBounds of 【{}】", wildcardType.getLowerBounds());
					}
					
				}
			}
			
			printBoundary();
		}
	}
	
	@Test
	public void testGenericDeclaration() throws NoSuchMethodException {
		
		Method mehtod = ReflectionUtils.findMethod(typeBeanClass, "typeVariables", null);
		Constructor constructor = typeBeanClass.getConstructor(Object.class);

		TypeVariable<?>[] classTypeVariables = typeBeanClass.getTypeParameters();
		TypeVariable<?>[] mehtodTypeVariables = mehtod.getTypeParameters();
		TypeVariable<?>[] constructorTypeVariables = constructor.getTypeParameters();

        typeVariableIfPossible(classTypeVariables[0]);
        typeVariableIfPossible(mehtodTypeVariables[0]);
        typeVariableIfPossible(constructorTypeVariables[0]);
	}
	
	private void parseMehthodParamters(String methodName) {
		Type[] typeArray = getTypes(methodName);
		
		for (Type type : typeArray) {
			logger.info("type of 【{}】", type);
			logger.info("class of 【{}】", type.getClass());
			printBoundary();
			parameterizedTypeIfPossible(type);
			genericArrayTypeIfPossible(type);
			typeVariableIfPossible(type);
			printBoundary();
		}
	}
	
	private Type[] getTypes(String methodName) {
		Method parameterizedtypesMethod = ReflectionUtils.findMethod(typeBeanClass, methodName, null);
		return parameterizedtypesMethod.getGenericParameterTypes();
	}
	
	/**
	 * E,T表示TypeVariable getGenericDeclaration 表示所在位置，GenericDeclaration子类
	 * Method
	 * @param type
	 */
	private void typeVariableIfPossible(Type type) {
		//TypeVariableImpl
		if (type instanceof TypeVariable) {
			TypeVariable typeVariable = (TypeVariable) type;
			logger.info("getBounds【{}】", Arrays.toString(typeVariable.getBounds()));
			logger.info("getGenericDeclaration【{}】", typeVariable.getGenericDeclaration().getClass());
		}
	}
	
	/**
	 * parameterizedType参数化类型的数组，用GenericArrayType表示 class数组类型，还是用class表示
	 * @param type
	 */
	private void genericArrayTypeIfPossible(Type type) {
		
		if (type instanceof Class) {
			Class genericArrayTypeClass = (Class) type;
			logger.info("ComponentType  of class【{}】", genericArrayTypeClass.getComponentType());
		}
		
		//GenericArrayTypeImpl
		if (type instanceof GenericArrayType) {
			GenericArrayType genericArrayType = (GenericArrayType) type;
			logger.info("ComponentType  of class【{}】", genericArrayType.getGenericComponentType());
		}
		
	}
	
	/**
	 * type 参数化类型
	 * ActualTypeArguments:去掉最外层<>就是它的值,ActualTypeArguments可能还是Type的子接口或class
	 * RawType:最外层<>的class
	 *
	 * @param type
	 */
	private void parameterizedTypeIfPossible(Type type) {
		//ParameterizedTypeImpl
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			logger.info("ActualTypeArguments【{}】", parameterizedType.getActualTypeArguments());
			logger.info("RawType【{}】", parameterizedType.getRawType());
			logger.info("OwnerType【{}】", parameterizedType.getOwnerType());
		}
		
	}
	
}
