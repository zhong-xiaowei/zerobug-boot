package cn.com.zerobug.module.impl.auth.manager.convert;

import cn.com.zerobug.module.api.system.dto.SysUserDTO;
import cn.com.zerobug.module.impl.auth.domain.vo.res.SysUserInfoResVO;
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
     * 转 info vo
     *
     * @param sysUserDTO
     * @return
     */
    SysUserInfoResVO convertInfoVO(SysUserDTO sysUserDTO);

}
