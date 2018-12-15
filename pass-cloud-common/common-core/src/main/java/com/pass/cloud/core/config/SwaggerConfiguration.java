package com.pass.cloud.core.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pass.cloud.config.PassCloudProperties;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author takesi
 */
@EnableSwagger2
public class SwaggerConfiguration {

    @Autowired
    private PassCloudProperties passCloudProperties;

    /**
     * Reservation api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessages())
                .globalResponseMessage(RequestMethod.POST, responseMessages())
                .globalResponseMessage(RequestMethod.PUT, responseMessages())
                .globalResponseMessage(RequestMethod.DELETE, responseMessages())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                //配置鉴权信息
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
//				.globalOperationParameters(pars)
                .enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(passCloudProperties.getSwagger().getTitle())
                .description(passCloudProperties.getSwagger().getDescription())
                .version(passCloudProperties.getSwagger().getVersion())
                .license(passCloudProperties.getSwagger().getLicense())
                .licenseUrl(passCloudProperties.getSwagger().getLicenseUrl())
                .contact(new Contact(passCloudProperties.getSwagger().getContactName(), passCloudProperties.getSwagger().getContactUrl(), passCloudProperties.getSwagger().getContactEmail()))
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return new ArrayList(Collections.singleton(new ApiKey("Authorization", "Authorization", "header")));
    }

    private List<SecurityContext> securityContexts() {
        return new ArrayList(
                Collections.singleton(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build())
        );
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return new ArrayList(Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
    }

    private List<ResponseMessage> responseMessages() {
        final List<ResponseMessage> responseMessageList = new ArrayList<>();

        responseMessageList.add(
                new ResponseMessageBuilder()
                        .code(401)
                        .message("无权限访问")
                        .build()
        );
        responseMessageList.add(
                new ResponseMessageBuilder()
                        .code(403)
                        .message("网关错误")
                        .build()
        );
        responseMessageList.add(
                new ResponseMessageBuilder()
                        .code(404)
                        .message("找不到资源")
                        .build()
        );
        responseMessageList.add(
                new ResponseMessageBuilder()
                        .code(500)
                        .message("服务器内部错误")
                        .build()
        );

        return responseMessageList;
    }

}
