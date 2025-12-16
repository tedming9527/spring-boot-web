package org.example.springbootweb.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimerInterceptor implements HandlerInterceptor {
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);
    System.out.println("startTime");
    return true;
  }
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) {
    long endTime = System.currentTimeMillis();
    request.setAttribute("endTime",endTime);
    System.out.println("endTime");
  }
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    // 1. 输出接口处理时间
    Long startTime = (Long) request.getAttribute("startTime");
    if (startTime != null) {
      long endTime = System.currentTimeMillis();
      System.out.println("本次请求处理时间为：" + (endTime - startTime) + "ms");
    } else {
      System.out.println("无法计算处理时间：startTime属性未设置");
    }
    request.removeAttribute("startTime");
  }
}
