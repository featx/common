package org.featx.jvmon.exception

import lombok.Getter

/**
 * @author Excepts
 */
class BusinessException private constructor(@field:Getter val businessError: BusinessError,
                                            @field:Getter val extra: Any?) : RuntimeException() {

    override val message: String?
        get() = businessError.message

    companion object {
        fun of(businessError: BusinessError, vararg extra: Any?): BusinessException {
            return BusinessException(businessError, extra)
        }
    }
}