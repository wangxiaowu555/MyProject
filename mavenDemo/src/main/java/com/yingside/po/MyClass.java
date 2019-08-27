package com.yingside.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MyClass {
    private int id;
    private String className;
    private String leader;
    private String leaderTel;
    private String number;
    private Date createDate;
    private List<Region> regions;
}
