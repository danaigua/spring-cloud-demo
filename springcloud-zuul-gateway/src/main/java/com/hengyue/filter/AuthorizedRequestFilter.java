package com.hengyue.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.nio.charset.Charset;
import java.util.Base64;

public class AuthorizedRequestFilter extends ZuulFilter {

    /**
     * 在进行zuul过滤的时候可以设置其过滤的位置，那么此时有如下几种类型
     * 第一种：pre         在请求之前，如果要进行访问，那么肯定要在请求之前设置头部信息
     * 2,route            在进行路由时被调用
     * 3,post              在进行路由之后被调用
     * 4,error               在出现错误时被调用
     * @return
     */
    @Override
    public String filterType() {

        return "pre";
    }

    @Override
    public int filterOrder() {
        /**
         * 设置优先级
         * 数字越大，优先级越低
         */
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /**
         * filter是否执行
         */
        return false;
    }
    /**
     * 表示具体的操作方法在过滤执行操作中
     * @return
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        /**
         * 认证的原始信息
         */
        String auth = "root:root";
        /**
         * 进行一个加密的处理
         */
        byte[] encodeAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodeAuth);
        /**
         * 把认证信息头部加到zull里面去，就可以访问被springSecurity加密过的访问路径
         */
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }
}
