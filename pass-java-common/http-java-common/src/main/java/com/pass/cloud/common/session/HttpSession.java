package com.pass.cloud.common.session;

import java.util.Enumeration;

/**
 * @author Daniel Qian
 */
public interface HttpSession {

    /**
     * getAttribute
     *
     * @param name
     * @return
     */
    Object getAttribute(String name);

    /**
     * getAttributeNames
     *
     * @return
     */
    Enumeration<String> getAttributeNames();

    /**
     * setAttribute
     *
     * @param name
     * @param value
     */
    void setAttribute(String name, Object value);

    /**
     * removeAttribute
     *
     * @param name
     */
    void removeAttribute(String name);

    /**
     * 校验
     */
    void invalidate();

}
