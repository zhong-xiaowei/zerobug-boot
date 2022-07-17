package cn.com.zerobug.module.impl.auth.framework.security.config;

import cn.com.zerobug.component.security.config.customizer.AbstractAuthorizeRequestsCustomizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author zhongxiaowei
 * @date 2022/3/20
 */
@Component
public class AuthAuthorizeRequestsCustomizer extends AbstractAuthorizeRequestsCustomizer {

    @Override
    public void customize(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry) {
        registry.antMatchers("/**")
                .anonymous();
    }
}
