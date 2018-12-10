package com.pass.cloud.common.session;

import java.util.Enumeration;

/**
 * @author Daniel Qian
 */
public interface HttpSession {

    Object getAttribute(String name);

    Enumeration<String> getAttributeNames();

    void setAttribute(String name, Object value);

    void removeAttribute(String name);

    void invalidate();

}
