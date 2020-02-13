package org.featx.spec.constant;

/**
 * @author Excepts
 * @since 2020/1/2 10:59
 */
public class Formatter {

    private Formatter() {

    }

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String TIME_PATTERN = "HH:mm:ss";

    public static final String DATE_TIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    public static final String DATE_TIME_MILLS_PATTERN = DATE_TIME_PATTERN + ".SSS";
}
