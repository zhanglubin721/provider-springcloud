package com.zhanglubin.providerspringcloud.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhanglubin
 * @date 2021/3/31
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("test1")
    public void test1(@RequestParam("id") Long id) {
        System.out.println(id);
        System.out.println(port);
    }
}
