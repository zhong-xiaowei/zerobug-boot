package cn.com.zerobug.module.impl.system.enums;

/**
 * @author zhongxiaowei
 * @date 2022/4/18
 */
public enum SysRoleCodeEnum {

    /**
     * 超级管理员
     */
    ADMIN("超级管理员", "admin");

    private String desc;
    private String code;

    SysRoleCodeEnum(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }
}
