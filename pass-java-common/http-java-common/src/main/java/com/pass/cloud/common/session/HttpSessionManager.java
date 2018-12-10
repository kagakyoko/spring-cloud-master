package com.pass.cloud.common.session;

/**
 * @author Daniel Qian
 */
public interface HttpSessionManager {

    /**
     * 获取某个sessionId对应的session,如果sessionId没有对应的session，则新建一个并返回。
     */
    HttpSession getSession(String sessionId);

    /**
     * 获取某个sessionId对应的session,如果sessionId没有对应的session，若create为true则新建一个，否则返回null。
     */
    HttpSession getSession(String sessionId, boolean create);

}
