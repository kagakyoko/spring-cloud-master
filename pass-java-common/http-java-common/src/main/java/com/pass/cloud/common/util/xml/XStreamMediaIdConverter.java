package com.pass.cloud.common.util.xml;

/**
 * @author takesi
 */
public class XStreamMediaIdConverter extends XStreamCDataConverter {
    @Override
    public String toString(Object obj) {
        return "<MediaId>" + super.toString(obj) + "</MediaId>";
    }
}
