package icu.aierx.elasticsearch.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ES {
    private String took;
    private String timed_out;
}
