package com.yingside.dao;

import com.yingside.po.Region;
import com.yingside.provider.RegionProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RegionMapper {

    //mybatis的关联查询其实有两种写法
    //1.使用 join的关联查询的写法
    //2.使用子查询的写法,纯粹只是用注解实现
    //其实mybatis里面自己只是实现了子查询的写法
    //如果想使用join的写法,就必须和xml的resultMap进行配合才行

    @Select("select * from t_region")
    @Results(id="rMap",value={
            @Result(property = "id",column = "pk_regionID",id = true),
            @Result(property = "regionName",column = "f_regionName"),
            @Result(property = "treeKind",column = "f_treeKind"),
            @Result(property = "type",column = "f_type"),
            @Result(property = "adTree",column = "f_adTree"),
            @Result(property = "myClass",column = "fk_classID",
                one = @One(select = "com.yingside.dao.MyClassMapper.getMyClass"
                        ,fetchType = FetchType.LAZY))
    })
    public List<Region> regionList2();

    @Results(id="rMap2",value= {
            @Result(property = "id", column = "pk_regionID", id = true),
            @Result(property = "regionName", column = "f_regionName"),
            @Result(property = "treeKind", column = "f_treeKind"),
            @Result(property = "type", column = "f_type"),
            @Result(property = "adTree", column = "f_adTree")
    })
    @Select("select * from t_region where fk_classID=#{classID}")
    public List<Region> regionListByClassID(@Param("classID") Integer classID);




    @SelectProvider(type= RegionProvider.class,method = "SQLRegionList")
    //由于现在没有使用注解的Results的声明,所以,这里要找ResultMap可以直接找到xml里面的ResultMap声明
    @ResultMap(value = "com.yingside.mapper.RegionMapper.regionMap")
    public List<Region> regionList();





}
