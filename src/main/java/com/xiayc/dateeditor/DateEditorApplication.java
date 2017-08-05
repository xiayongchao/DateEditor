package com.xiayc.dateeditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DateEditorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DateEditorApplication.class, args);
    }

    /*@Bean
    public DefaultBeanPostProcessor defaultBeanPostProcessor() {    //此方法用于启用DefaultBeanPostProcessor，另一种方法是在DefaultBeanPostProcessor上加@Component注解
        return new DefaultBeanPostProcessor();
    }*/
}
