package com.chenhe.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;

/**
 * @author chenhe
 * @Date 2018-07-17 10:47
 * @desc
 **/
@Component
public class IpFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(IpFilter.class);

    @Override
    public String filterType() {
        //前置过滤器
        String filterType = "pre";

        return filterType;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        logger.info("-- IP 白名单校验 --");
        RequestContext requestContext = RequestContext.getCurrentContext();
        ServletRequest request = requestContext.getRequest();
        String ip = request.getRemoteHost();
        logger.info("---- ip :{} -----",ip);

        filterIp(ip);

        requestContext.setResponseStatusCode(200);
        requestContext.set("isSuccess",true);
        return null;
    }

    private void filterIp(String ip){

    }
}
