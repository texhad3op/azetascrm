package com.cloudsole.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tmichels on 8/3/14.
 */

@Controller
@RequestMapping("/table")
public class TableController {

    @RequestMapping("/layout")
    public String layout(){
        return "table/layout";
    }
}
