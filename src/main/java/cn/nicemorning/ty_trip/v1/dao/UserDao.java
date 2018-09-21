/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: UserDao.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.dao;

import cn.nicemorning.ty_trip.v1.bean.UserBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户数据接口类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
@Repository
public interface UserDao extends CrudRepository<UserBean, String> {
}