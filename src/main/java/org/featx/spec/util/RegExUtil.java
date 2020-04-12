package org.featx.spec.util;

/**
 * @author Excepts
 * @since 2020/4/7 23:59
 */
public class RegExUtil {

    private RegExUtil() {

    }

    /**
     * Chinese mobile check
     * @param mobile The string to check
     * @return Boolean check Result
     */
    public static boolean isMobile(String mobile) {
        if (StringUtil.isBlank(mobile)) {
            return false;
        }
        return mobile.matches("1\\d{10}");
    }

    /**
     * Email check
     * @param email The string to check
     * @return Boolean check Result
     */
    public static boolean isEmail(String email) {

        if (StringUtil.isBlank(email)) {
            return false;
        }
        return email.matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-z]{2,}$");
    }
}
