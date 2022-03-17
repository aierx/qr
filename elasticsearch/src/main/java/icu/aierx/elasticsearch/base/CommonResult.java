package icu.aierx.elasticsearch.base;

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
public class CommonResult {

    Object data;
    String status;
    String msg;

    public static CommonResult SUCCESS(Object data){
        return new CommonResult(data,Status.SUCCESS.getValue(),null);
    }

    public static CommonResult FAILURE(Object data){
        return new CommonResult(data,Status.FAILURE.getValue(),null);
    }
}
