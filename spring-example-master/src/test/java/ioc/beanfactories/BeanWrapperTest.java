/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-23 17:20 创建
 *
 */
package ioc.beanfactories;

/**
 * @author jxilong@yiji.com
 */
public class BeanWrapperTest {

   /*
    PropertyEditorRegistry

    PropertyEditorRegistrySupport（属性编辑器注册实现）

    defaultEditorsActive:标示默认属性编辑器
    configValueEditorsActive：标示配置value属性编辑器

    conversionService：新的类型服务

    defaultEditors：默认编辑器
    overriddenDefaultEditors:覆盖的默认编辑器,取默认编辑器，它如果不为空优化取值

    customEditors:自定义编辑器
    customEditorsForPath：自定义编辑器(path)(path,CustomEditorHolder(class,PropertyEditor))

    customEditorCache：自定义编辑器查找缓存

    findCustomEditor(Class<?> requiredType, String propertyPath)
    1.如果propertyPath不为空用它，定位CustomEditor
            addStrippedPropertyPaths
    beanName[key][key2]-->beanName

    2.getCustomEditor(Class<?> requiredType)
    1.用类型定位CustomEditor
    2.用customEditorCache查找
    3.遍历所有类型customEditors,查找类是不是子类，如果存在保存在customEditorCache

    TypeConverterSupport（属性转换）
    typeConverterDelegate(propertyEditorRegistry(this),target)
    它的转换器从propertyEditorRegistry取

            AbstractPropertyAccessor
    extractOldValueForEditor：标示获取老的数据
    autoGrowNestedPaths：自动生成nestPath

            AbstractNestablePropertyAccessor
    autoGrowCollectionLimit：自动生成层数据限制数量
    object:target对象
    nestedPath：当前内部地址
    rootObject: 当前属性上层对象
    nestedPropertyAccessors：缓存内部属性访问器

    setPropertyValue(PropertyValue pv)


    PropertyValue
    name：名字
    value: 值
    source：来源
    optional:可选标示
    converted:是否转换
    conversionNecessary：是否需要转换
    resolvedTokens：PropertyTokenHolder

    beanName[key][key2]
    PropertyTokenHolder->getPropertyNameTokens
            actualName=beanName
    canonicalName=beanName[key][key2]
    keys=key,key2

    getNestedPropertyAccessor(String nestedProperty)
    1.取nestedProperty的值或默认值
    2.如果为空，或者类型不对，缓存起
    3.选择性把自定义属性编辑copy,conversionService
    this.nestedPath + canonicalName + "."


    getPropertyValue(PropertyTokenHolder tokens)

    setDefaultValue(PropertyTokenHolder tokens)

    setPropertyValue(PropertyTokenHolder tokens, PropertyValue pv)
    1.no keys
    BeanPropertyHandler
            PropertyDescriptor,propertyType,readable,writable
    conversionNecessary为空，必须转换  is easy

    2.keys 后面有时间再看了

    BeanWrapperImpl
    CachedIntrospectionResults:类反省缓存
    strongClassCache:当反省bean的classLoader ==CachedIntrospectionResults.classLoad或者
            是isClassLoaderAccepted
    softClassCache:否者是
    isClassLoaderAccepted:
    如果 flags == USE_ALL_BEANINFO，则使用可以发现的所有 BeanInfo 类。
    如果 flags == IGNORE_IMMEDIATE_BEANINFO，则忽略与指定 beanClass 相关联的任何 BeanInfo。
    如果 flags == IGNORE_ALL_BEANINFO，则忽略与指定 beanClass 相关联的所有 BeanInfo 及其所有父类

            beanInfo
    propertyDescriptorCache
            typeDescriptorCache*/

}
