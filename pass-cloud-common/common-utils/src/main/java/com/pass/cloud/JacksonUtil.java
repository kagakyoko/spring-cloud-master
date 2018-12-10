package com.pass.cloud;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author takesi
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JacksonUtil {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

}
