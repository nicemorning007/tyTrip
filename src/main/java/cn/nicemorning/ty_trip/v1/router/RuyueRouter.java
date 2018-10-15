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
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
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

    private String okhttpGetResponse(String url) {
        client = okHttpHelper.createClient();
        request = okHttpHelper.createRequest(url, Method.GET, null);
        String result = null;
        try {
            result = Objects.requireNonNull(okHttpHelper.getResponseAsync(client, request).body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result != null ? result : "";
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

    /**
     * 获取所有线路信息
     *
     * @param count     一次要获取的数量
     * @param pageindex 分页的当前页数
     * @return 如果成功返回Json字符串；否则返回null
     */
    public String getAllList(int count, int pageindex) {
        String url = "http://www.gzruyue.org.cn:8094/api/Product/ProductGetArrayList?index=0" +
                "&count=" + count + "&areas=0&pageindex=" + pageindex;
        return okhttpGetResponse(url);
    }

    /**
     * 通过站点搜索路线
     *
     * @param station 要搜索的站点
     * @param userId  用户ID
     * @return 如果成功返回Json字符串；否则返回null
     * @throws IOException 异步请求出错将抛出该异常
     */
    public String findStation(String station, String userId) throws IOException {
        String encode = URLEncoder.encode(station, "utf-8");
        String url = "http://www.gzruyue.org.cn:8094/api/Product/ProductGetListByStationName" +
                "?snm=" + encode + "&userid=" + userId;
        return okhttpGetResponse(url);
    }

    /**
     * 通过用户ID分页获取该用户的所有订单
     *
     * @param userId 用户ID
     * @param phone  用户如约手机号
     * @return 如果成功返回Json字符串；否则返回null
     * @throws IOException 异步请求出错将抛出该异常
     */
    public String getOrderInfoList(String userId, String phone, int index) throws IOException {
        String url = "http://busapi.gzruyue.org.cn:8089/ruyue-intercity/v1/intercity/getOrderInfoList";
        String json = "{\"userId\":\"" + userId + "\",\"index\":" + index + ",\"" +
                "count\":20,\"userPhone\":\"" + phone + "\",\"isBack\":0}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        client = okHttpHelper.createClient();
        request = okHttpHelper.createRequest(url, Method.POST, requestBody);
        String result = Objects.requireNonNull(okHttpHelper.getResponseAsync(client, request).body()).string();
        return result != null ? result : "";
    }

    /**
     * 通过OID获取订单详情
     *
     * @param oid 订单的ID
     * @return 如果成功返回Json字符串；否则返回null
     */
    public String getTicketDetail(String oid) {
        String url = "http://www.gzruyue.org.cn:8094/api/Order/OrderOdrTicketDetail?oid=" + oid;
        return okhttpGetResponse(url);
    }

    /**
     * 通过PID获取线路购票信息，如某日车次，座位等
     *
     * @param pid 要查询的线路PID
     * @return 如果成功返回Json字符串；否则返回null
     */
    public String getLineDetail(String pid) {
        String url = "http://www.gzruyue.org.cn:8094/api/Product/ProductDayArrayList?pid=" + pid;
        return okhttpGetResponse(url);
    }

    /**
     * 通过RID获取线路站点信息
     *
     * @param pid 要查询的线路RID
     * @return 如果成功返回Json字符串；否则返回null
     */
    public String getLineMap(String pid) {
        String url = "http://www.gzruyue.org.cn:8094/api/Station/RouteStionImgs?rid=" + pid;
        return okhttpGetResponse(url);
    }

    /**
     * 通过RID获取上车站点
     * @param rid 要查询的线路RID
     * @return 如果成功返回Json字符串；否则返回null
     */
    public String getUpStation(String rid) {
        String url = "http://www.gzruyue.org.cn:8094/api/Station/RouteUpStaion?rid=" + rid;
        return okhttpGetResponse(url);
    }

}
