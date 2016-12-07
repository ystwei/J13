package com.weikun.dao;

import com.weikun.vo.User;

/**
 * Created by Administrator on 2016/12/7.
 */
public interface IUserDAO {
    public void add();
    public void del();
    public void update() ;
    public void queryAll();
    public void queryById();
}
