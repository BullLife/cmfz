package com.csh.cmfz.entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 用来保存请求中的response和request
 * @Author 程少华
 * @Date 2018/7/9 20:12
 **/
public class SysContext {
    private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
    private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

    public static HttpServletRequest getRequestLocal() {
        return requestLocal.get();
    }

    public static void setRequestLocal(HttpServletRequest request) {
        requestLocal.set(request);
    }

    public static HttpServletResponse getResponseLocal() {
        return responseLocal.get();
    }

    public static void setResponseLocal(HttpServletResponse response) {
        responseLocal.set(response);
    }
}
