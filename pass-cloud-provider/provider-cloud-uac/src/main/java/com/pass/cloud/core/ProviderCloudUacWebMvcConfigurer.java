package com.pass.cloud.core;

import java.util.List;

import com.pass.cloud.config.properties.SwaggerProperties;
import com.pass.cloud.core.config.PcObjectMapper;
import com.pass.cloud.core.config.SwaggerConfiguration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author takesi
 */
@Configuration
@Import(SwaggerConfiguration.class)
@EnableConfigurationProperties(value = SwaggerProperties.class)
public class ProviderCloudUacWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        PcObjectMapper.buidMvcMessageConverter(converters);
    }

}
