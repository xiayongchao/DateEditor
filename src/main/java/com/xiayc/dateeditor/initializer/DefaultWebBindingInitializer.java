package com.xiayc.dateeditor.initializer;

import com.xiayc.dateeditor.editor.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Created by xyc on 2017/8/5 0005.
 */
public class DefaultWebBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        /**
         * 注册Date类型属性编辑器
         */
        webDataBinder.registerCustomEditor(Date.class, new DateEditor());
    }
}
