package com.gu01e.aicodegenerator.interceptor;

import com.gu01e.aicodegenerator.context.BaseContext;
import com.gu01e.aicodegenerator.properties.JwtProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author GUOLE
 * @version v1.0
 * @description jwt令牌校验的拦截器
 * @date 2025/10/14 21:51
 */
@Component
@Slf4j
@Order(2)
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 校验jwt
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1 查询ThreadLocal中的用户id
        Long empId = BaseContext.getCurrentId();
        if (empId == null) {
            log.info("用户未登录，请先登录");
            return false;
        }
        return true;
    }
}