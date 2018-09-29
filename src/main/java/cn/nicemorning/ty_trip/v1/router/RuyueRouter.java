/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueRouter.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.router;

import cn.nicemorning.ty_trip.utils.http.Method;
import cn.nicemorning.ty_trip.utils.http.OkHttpHelper;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/**
 * 如约数据请求类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
@Component
public class RuyueRouter implements Serializable {
    private static final long serialVersionUID = 8958345593319390930L;
    private WebClient webClient;
    private OkHttpClient client;
    private OkHttpHelper okHttpHelper = new OkHttpHelper();
    private Request request;
    private Call call;
    private Response response;

    /**
     * 构建一个默认的WebClient浏览器,通过getWebClient方法获取
     */
    public RuyueRouter() {
        this.webClient = new WebClient(BrowserVersion.CHROME);
        this.webClient.getOptions().setJavaScriptEnabled(true);
        this.webClient.getOptions().setCssEnabled(false);
        this.webClient.waitForBackgroundJavaScript(1000);
        this.webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        this.webClient.getOptions().setThrowExceptionOnScriptError(false);
    }

    /**
     * 构建WebClient浏览器，保存用户浏览器信息
     *
     * @return 构造好的WebClient浏览器
     */
    public WebClient getWebClient() {
        return webClient;
    }

    /**
     * 使用指定的WebClient获取指定url的html页面
     *
     * @param webClient 用来获取页面的WebClient浏览器
     * @param url       要获取的页面的url
     * @return 指定url的HTML页面
     * @throws IOException 获取页面IO异常
     */
    public HtmlPage getHtmlPage(WebClient webClient, String url) throws IOException {
        return webClient.getPage(url);
    }

    /**
     * 获取如约账号的用户ID
     *
     * @param webClient 该用户的WebClient浏览器实例
     * @param phone     用户如约手机号
     * @param password  用户如约密码
     * @return 如约账号的用户ID
     * @throws IOException          获取页面IO异常
     * @throws InterruptedException 线程休眠异常
     */
    public String getUid(WebClient webClient, String phone, String password) throws IOException, InterruptedException {
        //如约登陆界面
        HtmlPage htmlPage = webClient.getPage("http://ryxing.gzruyue.org.cn/login.html");
        HtmlInput ln = htmlPage.getHtmlElementById("username");
        HtmlInput pwd = htmlPage.getHtmlElementById("pass");
        DomNodeList<DomElement> btnList = htmlPage.getElementsByTagName("button");
        ln.setAttribute("value", phone);
        pwd.setAttribute("value", password);
        HtmlPage page2 = null;
        Thread.sleep(500);
        for (DomElement button : btnList) {
            page2 = button.click();
        }
        //要进入到这个页面如约才会将userId保存到cookies中
        webClient.getPage("http://ryxing.gzruyue.org.cn/my-order.html");
        Cookie uid = webClient.getCookieManager().getCookie("userId");
        return uid == null ? "" : uid.getValue();
    }

    public String getAllList(int count, int pageindex) throws IOException {
        String url = "http://www.gzruyue.org.cn:8094/api/Product/ProductGetArrayList?index=0" +
                "&count=" + count + "&areas=0&pageindex=" + pageindex;
        client = okHttpHelper.createClient();
        request = okHttpHelper.createRequest(url, Method.GET, null);
        String result = Objects.requireNonNull(okHttpHelper.getResponseAsync(client, request).body()).string();
        return result != null ? result : "";
    }

}
