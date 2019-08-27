package com.yingside.dao;

import com.yingside.po.MyClass;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface MyClassMapper {

    @Select("select * from t_class where pk_classID=#{id}")
    @Results(id="classMap",value = {
            @Result(column = "pk_classID",property = "id",id = true),
            @Result(column = "f_className",property = "className"),
            @Result(column = "f_leader",property = "leader"),
            @Result(column = "f_leaderTel",property = "leaderTel"),
            @Result(column = "f_number",property = "number"),
            @Result(column = "f_createDate",property = "createDate"),
            @Result(column = "pk_classID",property = "regions",
                    many = @Many(select = "com.yingside.dao.RegionMapper.regionListByClassID"
                            ,fetchType = FetchType.LAZY))
    })
    public MyClass getMyClass(Integer id);
}
