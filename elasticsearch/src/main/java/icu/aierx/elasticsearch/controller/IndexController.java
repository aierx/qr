package icu.aierx.elasticsearch.controller;

import icu.aierx.elasticsearch.base.CommonResult;
import icu.aierx.elasticsearch.dao.CityMapper;
import icu.aierx.elasticsearch.model.po.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
//@RestController("/")
public class IndexController {
    @Autowired
    CityMapper cityMapper;

    @GetMapping("/version")
    public CommonResult getVersion(){
        return CommonResult.SUCCESS("1.0.0");
    }

    @GetMapping("/city")
    public CommonResult getCityById(@RequestParam("id")Integer id){
        City city = cityMapper.selectByPrimaryKey(id);
        return CommonResult.SUCCESS(city);
    }
}
