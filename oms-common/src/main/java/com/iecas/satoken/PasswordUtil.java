package com.iecas.satoken;

import cn.dev33.satoken.secure.SaSecureUtil;

/**
 * 密码工具类
 */
public class PasswordUtil {
    public static String encode(String text){
        return SaSecureUtil.md5(text);
    }

}
