/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: ApplicationStater.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/30
 */
public class ApplicationStater extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TyTripApplication.class);
    }
}
