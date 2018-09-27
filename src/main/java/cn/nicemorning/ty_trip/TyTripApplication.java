/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: TyTripApplication.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TyTripApplication {
    //nohup java -jar codergroup-1.0.0-SNAPSHOT.jar >temp.txt &
    public static void main(String[] args) {
        SpringApplication.run(TyTripApplication.class, args);
    }
}
