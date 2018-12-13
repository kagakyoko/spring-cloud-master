package com.pass.cloud.activity.core;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author takesi
 */
@Configuration
public class ActivityCloudWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
        return () -> {
            Group group = identityService.newGroup("user");
            group.setName("users");
            group.setType("security-role");
            identityService.saveGroup(group);

            User admin = identityService.newUser("admin");
            admin.setPassword("admin");
            identityService.saveUser(admin);
        };
    }

}
