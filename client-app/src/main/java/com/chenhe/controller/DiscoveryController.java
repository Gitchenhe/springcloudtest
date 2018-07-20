package com.chenhe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author chenhe
 * @Date 2018-07-13 9:57
 * @desc
 **/
@RestController
public class DiscoveryController {

    private Logger logger = LoggerFactory.getLogger(DiscoveryController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("info")
    @ResponseBody
    public Object eurekaInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<p><strong>服务描述</strong></p>");
        stringBuilder.append("description")
                .append("&nbsp;")
                .append(client.description())
                .append("<br>");

        stringBuilder.append("<p><strong>所有服务实例</strong></p>");
        client.getServices().forEach(service -> appendDesc(stringBuilder, service));
        return stringBuilder;
    }

    private void appendDesc(StringBuilder stringBuilder, String service) {
        stringBuilder.append("service instance -> ").append(service).append("<br>");
    }

}
