package com.pet.test2.fallback;

import com.pet.models.Tmp;
import com.pet.test2.client.Test2FeignClient;
import com.pet.util.error.RequestError;
import com.pet.util.utils.Result;
import org.springframework.stereotype.Component;

@Component
public class Test2Fallback implements Test2FeignClient {
    @Override
    public Result<Tmp> getTest(String id)
    {
        return Result.wrapErrorResult(new RequestError());
    }

    @Override
    public String SayHello()
    {
        return "Bye";
    }
}
