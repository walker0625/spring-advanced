package com.minwoo.spring.advanced.app.proxy.v1;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/proxy")
@RestController
public interface LogicControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId); // interface에서는 @RequestParam("itemId")가 필요(jdk 버전마다 달라짐)

    @GetMapping("/v1/no-log")
    String noLog();

}
