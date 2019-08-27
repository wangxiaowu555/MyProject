package com.yingside.dao;

import com.yingside.po.MyClass;
import com.yingside.po.Region;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyClass {
    SqlSession sqlSession = null;
    Logger logger = Logger.getLogger(TestMyClass.class);

    @Before
    public void init(){
        String resources = "mybatis-config.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resources);

        //获取sqlSessionFactory工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession();
    }



    @Test
    public void test(){
        MyClassMapper mapper = sqlSession.getMapper(MyClassMapper.class);
        MyClass myClass = mapper.getMyClass(1);
        logger.info(myClass);
    }


}
