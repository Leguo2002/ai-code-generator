package com.gu01e.aicodegenerator.interceptor;

import cn.hutool.core.util.StrUtil;
import com.gu01e.aicodegenerator.constant.JwtClaimsConstant;
import com.gu01e.aicodegenerator.constant.RedisConstant;
import com.gu01e.aicodegenerator.context.BaseContext;
import com.gu01e.aicodegenerator.properties.JwtProperties;
import com.gu01e.aicodegenerator.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author GUOLE
 * @version v1.0
 * @description
 * @date 2025/10/14 22:09
 */
@Component
@Slf4j
@Order(1)
public class refreshTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1 获取当前请求的jwt令牌
        String token = request.getHeader("Authorization");
        //2 判断令牌是否存在，如果不存在，直接放行
        if (StrUtil.isBlank(token)) {
            return true;
        }
        //3 解析令牌，获取其中的用户id
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJwt(jwtProperties.getAdminSecretKey(), token);
            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
            if(stringRedisTemplate.opsForValue().get(RedisConstant.LOGIN_CODE_KEY + empId) == null) {
                return true;
            }
            BaseContext.setCurrentId(empId);
            log.info("当前员工id：{}", empId);
            //3、通过，放行
            return true;
        } catch (Exception e) {
            return true;
        }
    }

}