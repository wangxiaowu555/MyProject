package com.yingside.service;

import com.yingside.dao.WormMapper;
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

public class TestWormService {
    SqlSession sqlSession = null;
    Logger logger = Logger.getLogger(TestWormService.class);


    @Test
    public void testList(){
        WormServiceImpl wormService = new WormServiceImpl();
        PageBean<Worm> list = wormService.list();
        logger.info(list.getData());
    }


}
