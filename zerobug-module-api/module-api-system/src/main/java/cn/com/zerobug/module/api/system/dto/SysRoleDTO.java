package cn.com.zerobug.module.api.system.dto;

import lombok.Data;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
@Data
public class SysRoleDTO {

    /**
     * 角色id
     */
    private Long    id;
    /**
     * 角色名称
     */
    private String  name;
    /**
     * 角色标识
     */
    private String  code;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    private Integer dataScope;
    /**
     * 数据范围(指定部门数组)
     */
    private String  dataScopeDeptIds;
    /**
     * 角色状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 角色类型
     */
    private Integer type;

}
