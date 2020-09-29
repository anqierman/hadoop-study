package com.xiongdi.flume.custom;


import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.List;

public class CustomInterceptor implements Interceptor {
    //初始化方法
    public void initialize() {

    }
    //拦截处理方法
    //为了event的header添加key-value
    public Event intercept(Event event) {
        byte[] body = event.getBody();
        if(body[0] < 'z' && body[0] > 'a'){
            event.getHeaders().put("type", "letter");
        }else if(body[0] >'0' && body[0] < '9'){
            event.getHeaders().put("type", "number");
        }
        return event;
    }
    //拦截处理方法
    public List<Event> intercept(List<Event> list) {
        for(Event event: list){
            intercept(event);
        }
        return list;
    }

    public void close() {

    }
    //额外提供一个内部的Builder，因为Flume在创建拦截器对象时，固定调用Builder来获取
    public static class Builder implements Interceptor.Builder{
        //返回一个拦截器对象
        public Interceptor build() {
            return new CustomInterceptor();
        }
        //读取配置文件中的参数
        public void configure(Context context) {

        }
    }
}
