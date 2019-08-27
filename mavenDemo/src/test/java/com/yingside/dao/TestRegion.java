package com.yingside.dao;

import com.yingside.po.Region;
import com.yingside.po.Worm;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestRegion {
    SqlSession sqlSession = null;
    Logger logger = Logger.getLogger(TestRegion.class);

    @Before
    public void init(){
        String resources = "mybatis-config.xml";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resources);

        //获取sqlSessionFactory工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        sqlSession = build.openSession();
    }



    @Test
    public void testRegionList(){
        RegionMapper mapper = sqlSession.getMapper(RegionMapper.class);
        List<Region> list = mapper.regionList();
        for (Region region: list) {
            logger.info("Region===" + region);
        }
    }

    @Test
    public void testRegionList2(){
        RegionMapper mapper = sqlSession.getMapper(RegionMapper.class);
        List<Region> list = mapper.regionList2();
        for (Region region: list) {
            logger.info("Region===" + region);
        }
    }
}
