package cn.com.zerobug.module.api.system.dto;

import lombok.Data;

/**
 * @author zhongxiaowei
 * @date 2022/3/18
 */
@Data
public class SysUserDTO {

    /**
     * 用户id
     */
    private Long    id;
    /**
     * 用户账号
     */
    private String  username;
    /**
     * 密码
     */
    private String  password;
    /**
     * 用户昵称
     */
    private String  nickname;
    /**
     * 部门ID
     */
    private Long    deptId;
    /**
     * 用户邮箱
     */
    private String  email;
    /**
     * 手机号码
     */
    private String  mobile;
    /**
     * 用户性别
     */
    private Integer gender;
    /**
     * 头像地址
     */
    private String  avatar;
    /**
     * 帐号状态（0正常 1停用）
     */
    private Integer status;

}
