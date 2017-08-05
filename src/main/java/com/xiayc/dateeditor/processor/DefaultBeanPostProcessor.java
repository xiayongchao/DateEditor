package com.xiayc.dateeditor.processor;

import com.xiayc.dateeditor.initializer.DefaultWebBindingInitializer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * Created by xyc on 2017/8/5 0005.
 */
@Component  //@Component注解用于启用此功能
public class DefaultBeanPostProcessor implements BeanPostProcessor {
    /**
     * 实例化、依赖注入完毕，在调用显示的初始化之前完成一些定制的初始化任务
     *
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof RequestMappingHandlerAdapter) {
            RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) o;
            adapter.setWebBindingInitializer(new DefaultWebBindingInitializer());
        }
        return o;
    }

    /**
     * 实例化、依赖注入、初始化完毕时执行
     *
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
