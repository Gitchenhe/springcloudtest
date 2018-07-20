package com.chenhe.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenhe
 * @Date 2018-07-17 10:45
 * @desc
 **/
@Component
public class AuthFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public String filterType() {
        //前置过滤器
        String filterType = "pre";

        return filterType;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("-- Auth filter --");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        /*if (StringUtils.isBlank(token)){
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("auth failed!!!");
        }else {

        }*/
        requestContext.setResponseStatusCode(200);
        return null;
    }
}
