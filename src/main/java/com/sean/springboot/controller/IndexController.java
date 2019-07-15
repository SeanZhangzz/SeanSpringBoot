package com.sean.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/index.do")
    @ResponseBody
    public Map<String, String> index(){
        System.out.println("hello index controller");
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello","map");
        return map;
    }

}
