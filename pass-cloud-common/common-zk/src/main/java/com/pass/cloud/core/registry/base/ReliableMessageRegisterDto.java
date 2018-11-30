package com.pass.cloud.core.registry.base;

import com.google.common.base.Preconditions;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author takesi
 */
@Data
public class ReliableMessageRegisterDto {

    private String consumerGroup;

    private String producerGroup;

    private String nameSrvAddress;

    /**
     * Sets consumer group.
     *
     * @param consumerGroup the consumer group
     * @return the consumer group
     */
    public ReliableMessageRegisterDto setConsumerGroup(final String consumerGroup) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(consumerGroup), "init zk cid is null");
        this.consumerGroup = consumerGroup;
        return this;
    }

    /**
     * Sets producer group.
     *
     * @param producerGroup the producer group
     * @return the producer group
     */
    public ReliableMessageRegisterDto setProducerGroup(final String producerGroup) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(producerGroup), "init zk pid is null");
        this.producerGroup = producerGroup;
        return this;
    }

    /**
     * Sets nameSrv address.
     *
     * @param nameSrvAddress the nameSrv address
     * @return the nameSrv address
     */
    public ReliableMessageRegisterDto setNameSrvAddress(final String nameSrvAddress) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(nameSrvAddress), "init ZK nameSrvAddress is null");
        this.nameSrvAddress = nameSrvAddress;
        return this;
    }

}
