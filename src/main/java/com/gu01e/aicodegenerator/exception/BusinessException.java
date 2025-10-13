package com.gu01e.aicodegenerator.exception;

import lombok.Getter;

/**
 * @className: BusinessException
 * @Description: 业务异常
 * @version: v1.0
 * @author: GUOLE
 * @date: 2025/10/10 22:45
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}
