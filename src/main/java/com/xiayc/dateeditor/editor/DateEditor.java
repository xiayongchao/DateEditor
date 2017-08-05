package com.xiayc.dateeditor.editor;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xyc on 2017/8/5 0005.
 */
public class DateEditor extends PropertyEditorSupport {
    /**
     * 将外部设置的字符串转换为内部属性的值
     *
     * @param text The string to be parsed.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        //判断是否为空
        if (text == null || text.trim().equals("")) {
            super.setValue(null);
            return;
        }
        //判断是否为时间戳类型
        text = text.trim();
        if (text.matches("^[0-9]*$")) {
            super.setValue(new Date(Long.parseLong(text)));
            return;
        }
        //选取日期格式化格式（目前只支持：yyyy-MM-dd、HH:mm:ss、yyyy-MM-dd HH:mm:ss）
        String datePattern = null;
        if (StringUtils.countOccurrencesOf(text, "-") == 2) {
            datePattern = "yyyy-MM-dd";
        }
        if (StringUtils.countOccurrencesOf(text, ":") == 2) {
            datePattern = datePattern == null ? "HH:mm:ss" : datePattern + " HH:mm:ss";
        }
        if (datePattern == null) {
            throw new IllegalAccessError("不支持的时间格式，支持的时间格式：yyyy-MM-dd、HH:mm:ss、yyyy-MM-dd HH:mm:ss");
        }
        //进行格式化
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        try {
            super.setValue(format.parse(text));
        } catch (ParseException e) {
            throw new IllegalAccessError("格式化时间格式异常:" + e.getMessage());
        }
    }
}
