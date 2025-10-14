package com.gu01e.aicodegenerator.common;

import com.gu01e.aicodegenerator.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @className: BaseResponse
 * @Description: 基础响应封装类
 * @version: v1.0
 * @author: GUOLE
 * @date: 2025/10/10 22:42
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
