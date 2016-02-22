package com.cloudsole.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tmichels on 8/3/14.
 */

@Controller
@RequestMapping("/file")
public class FileController {

    //TODO: add different ways to drop files

    @RequestMapping("/layout")
    public String layout(){
        return "file/layout";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody void uploadFile(@RequestBody String file){
        //Transform String file to real file and return size of file
    }
}
