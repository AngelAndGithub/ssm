package com.xiaobin.common.listener;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

public class SessionListener implements HttpSessionAttributeListener{

    // 获取当前在线使用系统人数
    public final static String LISTENER_NAME = "_login";

    private static List sessions = new ArrayList();

    public void attributeAdded(HttpSessionBindingEvent event) {

        if(StringUtils.isEmpty(event.getName()) && event.getName().endsWith(LISTENER_NAME)){
            boolean flag = false;
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    public static List getSessions(){
        return sessions;
    }

}
