package com.pass.cloud.core;

import com.pass.cloud.core.configuration.SwaggerConfiguration;
import com.pass.cloud.core.properties.SwaggerProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author takesi
 */
@Configuration
@Import(SwaggerConfiguration.class)
@EnableConfigurationProperties(value = SwaggerProperties.class)
public class ProviderCloudMdcWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/");
    }
}
