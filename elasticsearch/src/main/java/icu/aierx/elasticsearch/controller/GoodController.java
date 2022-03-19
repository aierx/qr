package icu.aierx.elasticsearch.controller;

import icu.aierx.elasticsearch.base.CommonResult;
import icu.aierx.elasticsearch.entity.Good;
import icu.aierx.elasticsearch.repository.GoodRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */

@RestController
public class GoodController {

    private GoodRepository goodRepository;

    public GoodController(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @PostMapping("/good")
    public CommonResult insertGood(@Validated @RequestBody Good good){
        return CommonResult.SUCCESS(goodRepository.save(good));
    }

    @GetMapping("/good")
    public CommonResult getGoodById(@NotNull(message = "id")@RequestParam("id")Long id){
        return CommonResult.SUCCESS(goodRepository.findById(id));
    }
}
