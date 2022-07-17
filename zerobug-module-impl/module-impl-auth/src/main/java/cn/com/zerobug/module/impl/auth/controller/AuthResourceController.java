package cn.com.zerobug.module.impl.auth.controller;

import cn.com.zerobug.common.base.api.ApiResult;
import cn.com.zerobug.module.impl.auth.domain.vo.SysUserInfoVO;
import cn.com.zerobug.module.impl.auth.service.IAuthResourceService;
import cn.com.zerobug.component.security.utils.SecurityContextUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * 认证资源
 *
 * @author zhongxiaowei
 * @date 2022/4/10
 */
@RestController
@RequestMapping("auth/resource")
@RequiredArgsConstructor
public class AuthResourceController {

    private final IAuthResourceService authResourceService;

    /**
     * 获取登录用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/user-info")
    public ApiResult<SysUserInfoVO> getUserInfo() {
        return ApiResult.ok(authResourceService.getUserInfo(SecurityContextUtils.getLoginUserId()));
    }

    /**
     * 获取登录用户权限
     *
     * @return 权限集合
     */
    @GetMapping("/perm-code")
    public ApiResult<Set<String>> getUserPermission() {
        return ApiResult.ok(authResourceService.getUserPermission(SecurityContextUtils.getLoginUserId()));
    }

}
