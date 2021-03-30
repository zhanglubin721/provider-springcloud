package com.zhanglubin.providerspringcloud.provider.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zhanglubin.providerspringcloud.provider.fallback.TestServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhanglubin
 * @date 2021/3/30
 */
@FeignClient(name = "test-service", fallback = TestServiceFallBack.class)
public interface TestFeignService {


    @GetMapping("/test/getUser")
    void delete(@RequestParam("id") Long id);

}
