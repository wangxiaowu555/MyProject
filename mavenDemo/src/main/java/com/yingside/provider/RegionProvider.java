package com.yingside.provider;

import org.apache.ibatis.jdbc.SQL;

public class RegionProvider {
    public String SQLRegionList(){
        return new SQL(){
            {
                SELECT("t_region.pk_regionID,\n" +
                        "t_region.f_regionName,\n" +
                        "t_region.f_treeKind,\n" +
                        "t_region.f_type,\n" +
                        "t_region.f_adTree,\n" +
                        "t_region.fk_classID,\n" +
                        "t_class.pk_classID,\n" +
                        "t_class.f_className,\n" +
                        "t_class.f_leader,\n" +
                        "t_class.f_leaderTel,\n" +
                        "t_class.f_number,\n" +
                        "t_class.f_createDate");
                FROM("t_region");
                INNER_JOIN("t_class on t_region.fk_classID = t_class.pk_classID");
            }
        }.toString();
    }
}
