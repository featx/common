package org.featx.spec.feature

import java.lang.reflect.Method

/**
 * @author Excepts
 * @since 2020/6/20 23:09
 */
class ReflectionModelConverter : ModelConvert {
    override fun <T> convert(o: Any, type: Class<T>): T {
        val result = type.getDeclaredConstructor().newInstance()
        for (method in o.javaClass.methods) {
            if (!method.name.startsWith("get")) {
                continue
            }
            val setter: Method? =
                    type.getMethod(method.name.replaceFirst("get", "set"), method.returnType)
            setter?.invoke(result, method.invoke(o))
        }
        return result
    }
}