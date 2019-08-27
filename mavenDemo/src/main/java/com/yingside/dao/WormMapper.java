package com.yingside.dao;

import com.yingside.po.Worm;
import com.yingside.provider.WormProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WormMapper {

    //@Results必须写在第一个查询语句里面,不然这个@Results在后面是找不到的

//    @Select("select * from t_worm")
    @SelectProvider(type = WormProvider.class,method = "sqlList")
    @Results(id="wormMap",value = {
            @Result(column = "pk_wormID",property = "id",id=true),
            @Result(column = "f_wormName",property = "wormName"),
            @Result(column = "f_hostName",property = "hostName"),
            @Result(column = "f_breed",property = "breed"),
            @Result(column = "f_enemy",property = "enemy"),
            @Result(column = "f_childPic",property = "childPic"),
            @Result(column = "f_adultPic",property = "adultPic"),
            @Result(column = "f_solution",property = "solution"),
            @Result(column = "f_harm",property = "harm")
    })
    public List<Worm> list();

    @Select("select count(*) from t_worm")
    public int count();

    @Select("select * from t_worm order by pk_wormID limit ${(pageNo-1) * pageSize},${pageSize}")
    @ResultMap("wormMap")
    List<Worm> listByPage(@Param("pageNo") int pageNo,
                          @Param("pageSize") int pageSize);


    @Delete("delete from t_worm where pk_wormID=#{id}")
    int delete(@Param("id") int id);


//    @Select("<script>" +
//            "select * from t_worm " +
//            "<where>" +
//            "   <if test=\"wormName != null and !wormName.equals(&quot;&quot;)\">" +
//            "       and f_wormName like '%${wormName}%'"+
//            "   </if>" +
//            "   <if test=\"hostName != null and !hostName.equals(&quot;&quot;)\">" +
//            "       and f_hostName like '%${hostName}%'"+
//            "   </if>" +
//            "</where> " +
//            "order by pk_wormID limit ${(pageNo-1)*pageSize},${pageSize}" +
//            "</script>")
    @SelectProvider(type = WormProvider.class,method = "sqlQuery")
    @ResultMap("wormMap")
    //@Param 其实在mybatis在做内部处理的时候,都是当做了Map在进行处理
    List<Worm> query(@Param("wormName") String wormName,
                     @Param("hostName") String hostName,
                     @Param("pageNo") int pageNo,
                     @Param("pageSize") int pageSize);

    //上面使用@Param的写法,实际上和这个写法,在mybatis底层处理的时候是一样的
    //List<Worm> query(Map<String,Object> map);

    @Select("<script>" +
            "select count(*) from t_worm " +
            "<where>" +
            "   <if test=\"wormName != null and !wormName.equals(&quot;&quot;)\">" +
            "       and f_wormName like '%${wormName}%'"+
            "   </if>" +
            "   <if test=\"hostName != null and !hostName.equals(&quot;&quot;)\">" +
            "       and f_hostName like '%${hostName}%'"+
            "   </if>" +
            "</where> " +
            "</script>")
    int queryCount(@Param("wormName") String wormName,
                   @Param("hostName") String hostName);


    @UpdateProvider(type=WormProvider.class,method="updateSelective")
    int update(Worm worm);





}
