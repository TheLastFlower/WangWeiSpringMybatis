package com.springmybatis;

import com.wangwei.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;

/**
 * @author wangwei
 * @date 2022/6/12 12:11
 */
public class WangWeiImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

        // value -> com.wangwei.mapper
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(WangWeiBatisScan.class.getName());
        String path = (String) annotationAttributes.get("value");
        // Mapper扫描
        WangWeiScanner wangWeiScanner = new WangWeiScanner(registry);
        // ????
        wangWeiScanner.addIncludeFilter(new TypeFilter() {
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });
        wangWeiScanner.scan(path);

        // 用BeanDefinition的方式 定义 WangWeiFactoryBean
        // 有点看不懂了
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(WangWeiFactoryBean.class);
//        // 指定构造方法的入参 不用Spring自己找了
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
//        registry.registerBeanDefinition("userMapper", beanDefinition);
    }



}
