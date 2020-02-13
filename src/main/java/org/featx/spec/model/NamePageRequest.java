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
public class NamePageRequest extends PageRequest {

    private static final long serialVersionUID = 8301001300566089507L;

    private String name;

    @Override
    public NamePageRequest correctProperties() {
        super.correctProperties();
        if(StringUtil.isBlank(name)) {
            name = StringUtil.empty();
        }
        return this;
    }
}
