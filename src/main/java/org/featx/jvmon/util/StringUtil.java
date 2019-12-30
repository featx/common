package org.featx.jvmon.util;

import org.apache.groovy.json.internal.FastStringUtils;

/**
 * @author Excepts
 * @since 2019/12/30 16:33
 */
public class StringUtil {

    private StringUtil(){

    }

    public char[] toCharArray(String string) {
        return FastStringUtils.toCharArray(string);
    }

//    public boolean isBlank(String string) {
//        return
//    }
}
