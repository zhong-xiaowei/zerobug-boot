package cn.com.zerobug.module.impl.system.manager.convert;

import cn.com.zerobug.module.api.system.dto.SysUserDTO;
import cn.com.zerobug.module.impl.system.domain.dataobject.SysUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhongxiaowei
 * @date 2022/3/19
 */
@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    /**
     * 转 DTO
     *
     * @param sysUserDO
     * @return
     */
    SysUserDTO convertDTO(SysUserDO sysUserDO);


}
