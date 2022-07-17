package cn.com.zerobug.module.impl.auth.enums.errorcode;

import cn.com.zerobug.common.exception.enums.IErrorCode;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
public enum AuthErrorCode implements IErrorCode {

    /**
     * 用户名或密码错误
     */
    USER_NOT_FOUND(10101001, "用户名或密码不正确");

    /**
     * 错误代码
     */
    private final int    code;
    /**
     * 错误信息
     */
    private final String msg;

    AuthErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
