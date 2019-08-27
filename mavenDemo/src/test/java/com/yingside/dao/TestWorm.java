package com.yingside.dao;

import com.yingside.po.Worm;
import com.yingside.service.impl.WormServiceImpl;
import com.yingside.util.PageBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestWorm {
    SqlSession sqlSession = null;
    Logger logger = Logger.getLogger(TestWorm.class);

    //@Before 意思是 执行其他测试方法之前,都要先执行@Before里面的代码
    @Before
    public void init(){
        String resources = "mybatis-config.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resources);

        //获取sqlSessionFactory工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession();
    }



    @Test
    public void testList(){
        WormMapper mapper = sqlSession.getMapper(WormMapper.class);
        List<Worm> list = mapper.list();
        for (Worm worm : list) {
            logger.info("worm===" + worm);
        }
    }

    @Test
    public void testCount(){
        WormMapper mapper = sqlSession.getMapper(WormMapper.class);
        int count = mapper.count();
        logger.info(count);
    }

    @Test
    public void testListByPage(){
        WormMapper mapper = sqlSession.getMapper(WormMapper.class);
        List<Worm> list = mapper.listByPage(2,5);
        for (Worm worm : list) {
            logger.info("worm===" + worm);
        }
    }

    @Test
    public void testQuery(){
        WormMapper mapper = sqlSession.getMapper(WormMapper.class);
        List<Worm> list = mapper.query("","",1,5);
        for (Worm worm : list) {
            logger.info("worm===" + worm);
        }
    }

    @Test
    public void testUpdate(){
        WormMapper mapper = sqlSession.getMapper(WormMapper.class);
        Worm w = new Worm();
        w.setId(13);
        w.setHostName("银杏树");
        w.setWormName("蟑螂");
        w.setEnemy("鸟鸟");
        int update = mapper.update(w);
        sqlSession.commit();
        logger.info("=====" + update);


    }


}
