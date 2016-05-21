package com.zgljl2012.framework.permission;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 廖金龙
 * @version 2016年5月21日下午3:31:50
 * 权限管理注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Permission {
	/**
	 * 权限名称
	 * @return
	 */
	String name() default "";
}
