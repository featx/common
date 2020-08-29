package org.featx.spec.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Excepts
 * @since 2019/11/3 13:46
 */
public class StringUtil {

    private StringUtil() {

    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    public static List<String> dropEmpty(final List<String> strings) {
        return Optional.ofNullable(strings).filter(list -> !list.isEmpty())
                .map(list -> list.stream().filter(StringUtil::isNotEmpty).collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    public static List<String> dropBlank(final List<String> strings) {
        return Optional.ofNullable(strings).filter(list -> !list.isEmpty())
                .map(list -> list.stream().filter(StringUtil::isNotBlank).collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }

    public static String empty() {
        return "";
    }

    public static String trim(final String str) {
        return str == null ? null : str.trim();
    }

    public static String join(final Object[] array, String separator, final int startIndex, final int endIndex) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = empty();
        }

        // endIndex - startIndex > 0:   Len = NofStrings *(len(firstString) + len(separator))
        //           (Assuming that all Strings are roughly equally long)
        final int noOfItems = endIndex - startIndex;
        if (noOfItems <= 0) {
            return empty();
        }

        final StringBuilder buf = new StringBuilder(noOfItems * 16);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    public static String join(String[] strings) {
        return join(strings, ",");
    }

    public static String join(String[] strings, String separator) {
        if (strings == null) {
            return empty();
        }
        return join(strings, separator, 0, strings.length);
    }

    public static String join(Collection<String> strings) {
        return join(strings, ",");
    }

    public static String join(Collection<String> strings, String separator) {
        if (CollectionUtil.isEmpty(strings)) {
            return empty();
        }
        return join(strings.toArray(), separator, 0, strings.size());
    }

    public static String rand(int length, boolean isLetter) {
        StringBuilder buffer = new StringBuilder();
        String g = UUID.randomUUID().toString();

        Pattern p = Pattern.compile(isLetter ? "[0-9]" : "[^0-9]");
        Matcher match = p.matcher(g);
        g = match.replaceAll("");

        int lack = length - g.length();
        if (lack >= 0) {
            for (int i = 0; i < lack; i++) {
                buffer.append(isLetter ? 'x' : '0');
            }
            buffer.append(g);
        } else {
            byte[] data = g.getBytes();
            for (int i = 0; i < length; i++) {
                buffer.append((char) (data[i]));
            }
        }
        return buffer.toString();
    }
}
