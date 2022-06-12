package com.springmybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangwei
 * @date 2022/6/12 11:15
 *
 * 产生了两个对象  Factory的机制 什么机制??
 */
public class WangWeiFactoryBean implements FactoryBean {

    private SqlSession sqlSession;

    private Class mapperClass;  // UserMapper  OrderMapper


    // 推断构造
    public WangWeiFactoryBean(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    // setter 注入
    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperClass);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    // 由Mybatis生成代理对象
    public Object getObject() throws Exception {
//       return  Proxy.newProxyInstance(WangWeiFactoryBean.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(method.getName());
//                return null;
//            }
//        });

        return  sqlSession.getMapper(mapperClass);

    }

    public Class<?> getObjectType() {
        return mapperClass;
    }
}
