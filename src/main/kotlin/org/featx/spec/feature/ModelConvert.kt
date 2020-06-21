package org.featx.spec.feature

/**
 * @author Excepts
 * @since 2020/6/20 22:47
 */
interface ModelConvert {
    fun <T> convert(o: Any, type: Class<T>): T
}