package com.pass.cloud.core.registry.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author takesi
 */
@Data
@AllArgsConstructor
public class RegisterDto {

    private String app;

    private String host;

    private CoordinatorRegistryCenter coordinatorRegistryCenter;

}
