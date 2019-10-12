package org.featx.jvmon.exception

/**
 * @author Excepts
 * @since 2019/10/12 11:48
 */
object ErrorCode {

    const val NO_ERROR = 0
    /**
     * 缺少参数
     */
    const val PARAMETER_LOST = 4000010
    /**
     * 参数类型错误
     */
    const val PARAMETER_TYPE = 4000011
    /**
     * 参数无效，更细的业务校验不通过
     */
    const val PARAMETER_INVALID = 4000012
    /**
     * 查找不到相关信息
     */
    const val NOT_FOUND = 4040000
}
