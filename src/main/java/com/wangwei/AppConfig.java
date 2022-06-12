package com.wangwei;

import com.springmybatis.WangWeiBatisScan;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangwei
 * @date 2022/6/12 10:45
 */
@ComponentScan("com.wangwei")
@Configuration
@WangWeiBatisScan("com.wangwei.mapper")
public class AppConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {

        // 不通过Spring  利用Mybatis自身生成
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        return new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
}
