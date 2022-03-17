package icu.aierx.elasticsearch.controller;

import icu.aierx.elasticsearch.base.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
public class IndexController {
    @GetMapping
    public CommonResult getVersion(){
        return CommonResult.SUCCESS("1.0.0");
    }
}
