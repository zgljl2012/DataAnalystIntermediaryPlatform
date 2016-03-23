package com.zgljl2012.framework.service.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.AbstractService;

/**
 * @author 廖金龙
 * @version 2016年3月9日下午11:13:12
 * 用于给接口注入实现类的注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Impl {
	
	/**
	 * 默认的空类
	 * @author 廖金龙
	 *
	 */
	class Null extends AbstractService {

		public Null(Controller controller) {
			super(controller);
			// TODO Auto-generated constructor stub
		}
	}
	
	/**
	 * 直接声明需注入的实现类
	 * @return
	 */
	Class<? extends AbstractService> implClass() default Null.class;
	
	/**
	 * 声明实现类的名字：包名+类名
	 * 如：com.hello.HelloImpl
	 * @return
	 */
	String implName() default "";
}
