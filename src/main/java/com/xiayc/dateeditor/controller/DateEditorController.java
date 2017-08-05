package com.xiayc.dateeditor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xyc on 2017/8/5 0005.
 */
@RestController
@RequestMapping("/dateEditor")
public class DateEditorController {
    /**
     * 进行测试
     *
     * @param date
     * @return
     */
    @GetMapping("/test")
    public Date test(Date date) {
        System.out.println(date);
        return date;
    }
}
