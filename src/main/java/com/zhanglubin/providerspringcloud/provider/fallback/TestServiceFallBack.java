package com.zhanglubin.providerspringcloud.provider.fallback;

import com.zhanglubin.providerspringcloud.provider.feign.TestFeignService;
import org.springframework.stereotype.Component;

/**
 * @author zhanglubin
 * @date 2021/3/30
 */
@Component
public class TestServiceFallBack implements TestFeignService{


    @Override
    public void delete(Long id) {
        System.out.println("-------------" + id + "-------------");
        System.out.println("------------已进入熔断方法--------------");
    }

}
