package com.pass.cloud.mdc.model.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author takesi
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MdcApiConstant {

    /**
     * The enum Product status enum.
     *
     * @author takesi
     */
    public enum ProductStatusEnum {
        /**
         * On sale product status enum.
         */
        ON_SALE(1, "在线"),
        /**
         * Off sale product status enum.
         */
        OFF_SALE(2, "下架"),
        /**
         * Delete product status enum.
         */
        DELETE(3, "删除");
        private String value;
        private int code;

        ProductStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * Gets code.
         *
         * @return the code
         */
        public int getCode() {
            return code;
        }
    }

}
