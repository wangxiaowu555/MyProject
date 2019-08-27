package com.yingside.util;

import org.apache.ibatis.session.SqlSession;

public class SqlSessionUtil {
    //ThreadLocal 线程的变量池
    //把没一个用户创建的sqlSession放入到线程池中,如果线程池中没有就创建,如果已经有了
    //就直接从线程池中拿去出来
    //所以ThreadLocal保存的是键值对
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();

    public static SqlSession getSqlSession(){
        //先从线程池中拿取sqlsession
        SqlSession sqlSession = tl.get();
        //如果sqlsession==null,说明线程池中没有
        if(sqlSession == null){
            sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
            //把获取到的sqlSession放入线程池
            tl.set(sqlSession);
        }

        return sqlSession;
    }

    public static void commit(){
        SqlSession sqlSession = tl.get();
        //从线程池中拿取到SqlSession
        //执行sqlSession.commit();并且把线程池中的内容清空
        if (sqlSession != null) {
            sqlSession.commit();
            tl.set(null);
        }
    }
}
