package com.zhanglubin.providerspringcloud.provider.feign;

import com.zhanglubin.providerspringcloud.provider.fallback.TestServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhanglubin
 * @date 2021/3/30
 */
@FeignClient(name = "provider-springcloud", fallback = TestServiceFallBack.class)
public interface TestFeignService {


    @GetMapping("/test/test1")
    void delete(@RequestParam("id") Long id);

}
