package com.springmybatis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangwei
 * @date 2022/6/12 12:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(WangWeiImportBeanDefinitionRegistrar.class)
public @interface WangWeiBatisScan {

    // 扫描路径
    String value() default "";
}
