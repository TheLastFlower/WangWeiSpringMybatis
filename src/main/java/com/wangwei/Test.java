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
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfig.class);

        // 用BeanDefinition的方式 定义 WangWeiFactoryBean
        // 有点看不懂了
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(WangWeiFactoryBean.class);
        // 指定构造方法的入参 不用Spring自己找了
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
        applicationContext.registerBeanDefinition("userMapper", beanDefinition);

        applicationContext.refresh();

        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.test();
//        System.out.println(applicationContext.getBean("wangWeiFactoryBean")); // getObject产生的Bean
//        System.out.println(applicationContext.getBean("&wangWeiFactoryBean")); //WangWeiFactoryBean

    }
}
