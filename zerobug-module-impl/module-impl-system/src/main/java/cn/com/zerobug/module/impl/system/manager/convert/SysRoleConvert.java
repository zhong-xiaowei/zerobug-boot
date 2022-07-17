package cn.com.zerobug.module.impl.system.manager.convert;

import cn.com.zerobug.module.api.system.dto.SysRoleDTO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysRoleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhongxiaowei
 * @date 2022/4/10
 */
@Mapper
public interface SysRoleConvert {

    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    /**
     * 将SysRoleDO转换为SysRoleDTO
     *
     * @param sysRoleDO
     * @return
     */
    SysRoleDTO convertDTO(SysRoleDO sysRoleDO);

}
