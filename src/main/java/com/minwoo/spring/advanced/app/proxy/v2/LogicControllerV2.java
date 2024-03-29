package com.minwoo.spring.advanced.app.proxy.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/proxy")
@RequiredArgsConstructor
public class LogicControllerV2 {

    private final LogicServiceV2 logicService;

    @GetMapping("/v2/request")
    public String request(@RequestParam("itemId") String itemId) {
        logicService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }

}