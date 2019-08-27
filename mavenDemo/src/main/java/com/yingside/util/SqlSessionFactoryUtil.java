package com.yingside.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionFactoryUtil() {
    }

    synchronized public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null) {
            String resources = "mybatis-config.xml";
            InputStream is = null;
            try {
                is = Resources.getResourceAsStream(resources);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //获取sqlSessionFactory工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }

        return sqlSessionFactory;
    }
}
