package com.pass.cloud.base.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @param <K>
 * @param <V>
 * @author takesi
 */
@Data
public class KvDto<K, V> implements Serializable {

    private static final long serialVersionUID = -7712636075929650779L;

    /**
     * Instantiates a new Kv dto.
     */
    public KvDto() {
    }

    /**
     * Instantiates a new Kv dto.
     *
     * @param key   the key
     * @param value the value
     */
    public KvDto(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * key
     */
    private K key;
    /**
     * value
     */
    private V value;

}
