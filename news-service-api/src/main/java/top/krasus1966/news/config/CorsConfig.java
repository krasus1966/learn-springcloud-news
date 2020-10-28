package top.krasus1966.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Krasus1966
 * @date 2020/10/28 17:03
 **/
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        // 添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        // 设置是否发送cookie信息
        config.setAllowCredentials(true);
        // 设置允许请求的方式
        config.addAllowedMethod("*");
        // 设置允许的header
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        // 为url添加映射路径
        corsSource.registerCorsConfiguration("/**",config);
        return new CorsFilter(corsSource);
    }
}
