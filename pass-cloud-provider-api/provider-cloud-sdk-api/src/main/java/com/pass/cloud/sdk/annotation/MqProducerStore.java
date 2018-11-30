package com.pass.cloud.sdk.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pass.cloud.sdk.model.enums.DelayLevelEnum;
import com.pass.cloud.sdk.model.enums.MqOrderTypeEnum;
import com.pass.cloud.sdk.model.enums.MqSendTypeEnum;

/**
 * 保存生产者信息
 *
 * @author takesi
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MqProducerStore {

    MqSendTypeEnum sendType() default MqSendTypeEnum.WAIT_CONFIRM;

    MqOrderTypeEnum orderType() default MqOrderTypeEnum.ORDER;

    DelayLevelEnum delayLevel() default DelayLevelEnum.ZERO;

}
