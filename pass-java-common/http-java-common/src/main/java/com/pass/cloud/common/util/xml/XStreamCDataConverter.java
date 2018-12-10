package com.pass.cloud.common.util.xml;

import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * @author takesi
 */
public class XStreamCDataConverter extends StringConverter {

    @Override
    public String toString(Object obj) {
        return "<![CDATA[" + super.toString(obj) + "]]>";
    }

}
