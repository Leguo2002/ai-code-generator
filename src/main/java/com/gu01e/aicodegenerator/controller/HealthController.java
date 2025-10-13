package com.gu01e.aicodegenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HealthController
 * @Description: 业务健康检查
 * @version: v1.0
 * @author: GUOLE
 * @date: 2025/10/10 22:35
 */
@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping("/")
    public String health() {
        return "I'm fine";
    }
}