package com.yingside.service;

import com.yingside.po.Worm;
import com.yingside.util.PageBean;

public interface WormService {
    PageBean<Worm> list();

    PageBean<Worm> listByPage(int pageNo, int pageSize);

    boolean delete(int id);

    PageBean<Worm> query(String wormName,
                         String hostName,
                         int pageNo,
                         int pageSize);
}
