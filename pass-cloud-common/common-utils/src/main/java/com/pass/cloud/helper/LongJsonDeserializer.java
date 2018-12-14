package com.pass.cloud.helper;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import lombok.extern.slf4j.Slf4j;

/**
 * 将字符串转为Long
 *
 * @author takesi
 */
@Slf4j
public class LongJsonDeserializer extends JsonDeserializer<Long> {

    @Override
    public Long deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = null;
        try {
            value = jsonParser.getText();
        } catch (IOException e) {
            log.error("deserialize={}", e.getMessage(), e);
        }
        try {
            return value == null ? null : Long.parseLong(value);
        } catch (NumberFormatException e) {
            log.error("解析长整形错误", e);
            return null;
        }
    }

}
