package com.zhanglubin.providerspringcloud.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhanglubin.providerspringcloud.provider.feign.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhanglubin
 * @date 2021/3/30
 */
@Controller
@RequestMapping("/test1")
public class ProviderController {


    @Qualifier("com.zhanglubin.providerspringcloud.provider.feign.TestFeignService")
    @Autowired
    private TestFeignService testFeignService;

    @Autowired
    private RestTemplate restTemplate;

    //使用restTemplate可以使用HystrixCommand注解
    @HystrixCommand(fallbackMethod = "aaa")
    @RequestMapping("/test1")
    public void testProviderFeign1() {
        System.out.println("-------进入test1--------");
        restTemplate.getForObject("http://127.0.0.1:9081/test1/test4", void.class);
    }

    //使用Feign调用只能使用fallback或者fallbackFactory,会自动映射对应fallback方法
    @RequestMapping("/test2")
    public void testProviderFeign2() {
        System.out.println("-------进入test2----------");
        testFeignService.delete(1L);
    }

    public void aaa() {
        System.out.println("-----------aaaa------------");
    }
}
