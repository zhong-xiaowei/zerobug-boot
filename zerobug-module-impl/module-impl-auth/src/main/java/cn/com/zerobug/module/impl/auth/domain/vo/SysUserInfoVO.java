package cn.com.zerobug.module.impl.auth.domain.vo;

import cn.com.zerobug.module.api.system.dto.SysRoleDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhongxiaowei
 * @date 2022/3/22
 */
@Data
public class SysUserInfoVO implements Serializable {

    private static final long serialVersionUID = 6810970117102121236L;

    /**
     * 用户id
     */
    private Long             id;
    /**
     * 用户账号
     */
    private String           username;
    /**
     * 用户昵称
     */
    private String           nickname;
    /**
     * 部门ID
     */
    private Long             deptId;
    /**
     * 用户邮箱
     */
    private String           email;
    /**
     * 手机号码
     */
    private String           mobile;
    /**
     * 用户性别
     */
    private Integer          gender;
    /**
     * 头像地址
     */
    private String           avatar;
    /**
     * 帐号状态（0正常 1停用）
     */
    private Integer          status;
    /**
     * 用户角色
     */
    private List<SysRoleDTO> roles;

}
