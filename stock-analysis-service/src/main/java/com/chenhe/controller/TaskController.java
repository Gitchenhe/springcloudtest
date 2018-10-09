package com.chenhe.controller;

import com.chenhe.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenhe
 * @Date 2018-09-27 16:17
 * @desc
 **/
@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("stockInfo")
    public String stockQuery() {
        taskService.stockInfoQuery();
        return "ok";
    }
}
