package com.wangwei;

import com.springmybatis.WangWeiFactoryBean;
import com.wangwei.mapper.UserMapper;
import com.wangwei.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangwei
 * @date 2022/6/12 10:45
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


//        UserService userService = (UserService)applicationContext.getBean("userService");
//        userService.test();
//        System.out.println(applicationContext.getBean("wangWeiFactoryBean")); // getObject产生的Bean
//        System.out.println(applicationContext.getBean("&wangWeiFactoryBean")); //WangWeiFactoryBean

    }
}
