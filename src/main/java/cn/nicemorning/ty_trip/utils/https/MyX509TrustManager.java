/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: MyX509TrustManager.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.utils.https;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * SSL证书验证类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/17
 */
public class MyX509TrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
