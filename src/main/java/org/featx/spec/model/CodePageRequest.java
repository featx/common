package org.featx.spec.model;

import org.featx.spec.util.StringUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Excepts
 * @since 2019/12/31 13:45
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CodePageRequest extends PageRequest {

    private static final long serialVersionUID = 6791210085937176093L;

    private String code;

    @Override
    public CodePageRequest correctProperties() {
        super.correctProperties();
        if(StringUtil.isBlank(code)) {
            code = StringUtil.empty();
        }
        return this;
    }
}
