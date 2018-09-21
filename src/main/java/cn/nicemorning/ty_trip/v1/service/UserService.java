/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: UserService.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.service;

import cn.nicemorning.ty_trip.v1.bean.UserBean;
import cn.nicemorning.ty_trip.v1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户数据业务类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public synchronized UserBean addOrUpdateUser(UserBean userBean) {
        return userDao.save(userBean);
    }

    public UserBean getUserByOpenId(String encodeOpenId) {
        Optional<UserBean> userBean = userDao.findById(encodeOpenId);
        return userBean.orElseGet(() -> addOrUpdateUser(new UserBean(encodeOpenId)));
    }
}
