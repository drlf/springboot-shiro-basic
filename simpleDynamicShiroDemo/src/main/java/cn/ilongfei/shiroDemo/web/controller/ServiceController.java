package cn.ilongfei.shiroDemo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-26
 * <p>Version: 1.0
 */
@RestController
public class ServiceController {

    @RequestMapping("/hello")
    public String hello1(String[] param1, String param2) {
        return "hello" + param1[0] + param1[1] + param2;
    }
    
    @RequestMapping("/hello1")
    public String hello1() {
        return "hello1";
    }
    
    @RequestMapping("/api/hello")
    public String apiHello() {
        return "api hello";
    }
}
