package com.jiajinshuo.mplus.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiajinshuo
 * @create 2020-05-18 13:59
 */
@RestController
public class HelloController {

    @ApiOperation("hello的控制器")
    @GetMapping("/hello")
    public String hello(){
        return "helloworld";
    }
}
