package com.pet.test2.client;

import com.pet.models.Tmp;
import com.pet.test2.fallback.Test2Fallback;
import com.pet.util.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-test2",url = "http://localhost:8888",fallback = Test2Fallback.class)
@Component
public interface Test2FeignClient {
    //测试
    @RequestMapping(value = "/api/test2/getTest/{id}",method = RequestMethod.GET)
    public Result<Tmp> getTest(@PathVariable("id") String id);

    @RequestMapping(value = "/api/test2/testFeign2",method = RequestMethod.GET)
    public String SayHello();
}
