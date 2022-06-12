package com.springmybatis;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @author wangwei
 * @date 2022/6/12 15:34
 */
public class WangWeiScanner extends ClassPathBeanDefinitionScanner {

    public WangWeiScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    // Spring不会扫描接口 因为接口创建不了对象
    // 但我们希望能够扫描到Mapper接口
   // 重写
    // Candidate 候选的
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }


    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);

        return beanDefinitionHolders;
    }
}
