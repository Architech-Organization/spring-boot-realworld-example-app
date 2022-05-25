package io.spring.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {
  private static final Logger LOGGER = LoggerFactory.getLogger(Interceptor.class);

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    final String requestMethod = request.getMethod();
    final String requestURI = request.getRequestURI();
    LOGGER.info("[" + requestMethod + "] " + requestURI + " " + response.getStatus());
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}
