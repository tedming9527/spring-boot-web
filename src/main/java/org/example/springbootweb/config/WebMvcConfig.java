package org.example.springbootweb.config;

import org.example.springbootweb.interceptor.LogInterceptor;
import org.example.springbootweb.interceptor.TimerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Autowired
  LogInterceptor logInterceptor;
  @Autowired
  TimerInterceptor timerInterceptor;
  // 1. 添加log,time拦截器
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(logInterceptor);
    registry.addInterceptor(timerInterceptor);
  }
}
