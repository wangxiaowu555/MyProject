package com.yingside.service.impl;

import com.yingside.dao.WormMapper;
import com.yingside.po.Worm;
import com.yingside.service.WormService;
import com.yingside.util.PageBean;
import com.yingside.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class WormServiceImpl implements WormService {


    public PageBean<Worm> list() {
        PageBean<Worm> pageBean = null;
        try {
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
            WormMapper mapper = sqlSession.getMapper(WormMapper.class);
            List<Worm> list = mapper.list();
            int count = mapper.count();
            pageBean = new PageBean<>(0,"",count,list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageBean;
    }

    @Override
    public PageBean<Worm> listByPage(int pageNo, int pageSize) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        WormMapper mapper = sqlSession.getMapper(WormMapper.class);
        List<Worm> list = mapper.listByPage(pageNo,pageSize);
        int count = mapper.count();

        PageBean<Worm> pageBean = new PageBean<>(count,list,pageNo,pageSize);

        return pageBean;
    }

    @Override
    public boolean delete(int id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        WormMapper mapper = sqlSession.getMapper(WormMapper.class);
        int i = mapper.delete(id);

        SqlSessionUtil.commit();
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public PageBean<Worm> query(String wormName, String hostName, int pageNo, int pageSize) {
        PageBean<Worm> pageBean = null;
        try {
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
            WormMapper mapper = sqlSession.getMapper(WormMapper.class);
            int count = mapper.queryCount(wormName, hostName);
            List<Worm> query = mapper.query(wormName, hostName, pageNo, pageSize);
            pageBean = new PageBean<>(count,query,pageNo,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            SqlSessionUtil.commit();
        }

        return pageBean;
    }
}
