package com.gu01e.aicodegenerator.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

/**
 * @author GUOLE
 * @version v1.0
 * @description TODO
 * @date 2025/10/14 23:54
 */
@Getter
public enum UserRoleEnum {

    ADMIN("管理员", "admin"),
    USER("用户", "user");

    private final String text;
    private final String value;
    UserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     *
     * @description 根据value获得UserRoleEnum枚举对象
     * @paramtype java.lang.String
     * @param value
     * @return com.gu01e.aicodegenerator.model.enums.UserRoleEnum
     * @date 2025/10/14 23:58
     *
     */
    public static UserRoleEnum getEnumByValue(String value) {
        if (ObjUtil.isEmpty(value)) {
            return null;
        }
        for (UserRoleEnum roleEnum : UserRoleEnum.values()) {
            if (roleEnum.value.equals(value)) {
                return roleEnum;
            }
        }
        return null;
    }
}
