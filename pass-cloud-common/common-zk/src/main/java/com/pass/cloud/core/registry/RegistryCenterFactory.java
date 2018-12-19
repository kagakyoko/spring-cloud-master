package com.pass.cloud.core.registry;

import java.util.concurrent.ConcurrentHashMap;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.pass.cloud.config.PassCloudProperties;
import com.pass.cloud.config.properties.AliyunProperties;
import com.pass.cloud.config.properties.ZookeeperProperties;
import com.pass.cloud.core.generator.IncrementIdGenerator;
import com.pass.cloud.core.registry.base.CoordinatorRegistryCenter;
import com.pass.cloud.core.registry.base.RegisterDto;
import com.pass.cloud.core.registry.zookeeper.ZookeeperRegistryCenter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author takesi
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegistryCenterFactory {

    private static final ConcurrentHashMap<HashCode, CoordinatorRegistryCenter> REG_CENTER_REGISTRY = new ConcurrentHashMap<>();

    /**
     * 创建注册中心.
     *
     * @param zookeeperProperties the zookeeper properties
     * @return 注册中心对象 coordinator registry center
     */
    @Deprecated
    public static CoordinatorRegistryCenter createCoordinatorRegistryCenter(ZookeeperProperties zookeeperProperties) {
        Hasher hasher = Hashing.md5().newHasher().putString(zookeeperProperties.getZkAddressList(), Charsets.UTF_8);
        HashCode hashCode = hasher.hash();
        CoordinatorRegistryCenter result = REG_CENTER_REGISTRY.get(hashCode);
        if (null != result) {
            return result;
        }
        result = new ZookeeperRegistryCenter(zookeeperProperties);
        result.init();
        REG_CENTER_REGISTRY.put(hashCode, result);
        return result;
    }

    /**
     * Startup.
     *
     * @param passCloudProperties
     * @param host                the host
     * @param app                 the apps
     */
    public static void startup(PassCloudProperties passCloudProperties, String host, String app) {
        CoordinatorRegistryCenter coordinatorRegistryCenter = createCoordinatorRegistryCenter(passCloudProperties.getZk());
        RegisterDto dto = new RegisterDto(app, host, coordinatorRegistryCenter);
        Long serviceId = new IncrementIdGenerator(dto).nextId();
        IncrementIdGenerator.setServiceId(serviceId);
        registerMq(passCloudProperties, host, app);
    }

    private static void registerMq(PassCloudProperties passCloudProperties, String host, String app) {
        CoordinatorRegistryCenter coordinatorRegistryCenter = createCoordinatorRegistryCenter(passCloudProperties.getZk());
        AliyunProperties.RocketMqProperties rocketMq = passCloudProperties.getAliyun().getRocketMq();
        String consumerGroup = rocketMq.isReliableMessageConsumer() ? rocketMq.getConsumerGroup() : null;
        String namesrvAddr = rocketMq.getNamesrvAddr();
        String producerGroup = rocketMq.isReliableMessageProducer() ? rocketMq.getProducerGroup() : null;
        coordinatorRegistryCenter.registerMq(app, host, producerGroup, consumerGroup, namesrvAddr);
    }

}
