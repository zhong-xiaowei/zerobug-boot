package cn.com.zerobug.module.impl.system.framework.security.config;

import cn.com.zerobug.component.security.config.customizer.AbstractAuthorizeRequestsCustomizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author zhongxiaowei
 * @date 2022/3/20
 */
@Component
public class SystemAuthorizeRequestsCustomizer extends AbstractAuthorizeRequestsCustomizer {

    @Override
    public void customize(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry) {
        // Swagger 接口文档
//        registry.antMatchers("/swagger-ui.html").anonymous()
//                .antMatchers("/swagger-resources/**").anonymous()
//                .antMatchers("/webjars/**").anonymous()
//                .antMatchers("/*/api-docs").anonymous();
    }
}
