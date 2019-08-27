package com.yingside.provider;

import com.yingside.po.Worm;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class WormProvider {

    public String sqlList(){
        //return "select * from t_worm";
        return  new SQL(){
            {
                SELECT("*");
                FROM("t_worm");
            }
        }.toString();
    }

    public String sqlQuery(final )Map<String,Object> map{

        return new SQL(){
            {
                SELECT("*");
                FROM("t_worm");
                if(map.get("wormName") != null && !map.get("wormName").equals("")){
                    AND().WHERE("f_wormName like '%${wormName}%'");
                }
                if(map.get("hostName") != null && !map.get("hostName").equals("")){
                    AND().WHERE("f_hostName like '%${hostName}%'");
                }
                ORDER_BY("pk_wormID");
                LIMIT("${(pageNo-1)*pageSize},${pageSize}");
            }
        }.toString();

    }

    public String updateSelective(final Worm worm){
        return new SQL(){
            {
                UPDATE("t_worm");
                if(worm.getWormName()!=null || !worm.getWormName().equals("")){
                    SET("f_wormName=#{wormName}");
                }
                if(worm.getHostName()!=null || !worm.getHostName().equals("")){
                    SET("f_hostName=#{hostName}");
                }
                if(worm.getEnemy()!=null || !worm.getEnemy().equals("")){
                    SET("f_enemy=#{enemy}");
                }
                WHERE("pk_wormID=#{id}");
            }
        }.toString();
    }
}
