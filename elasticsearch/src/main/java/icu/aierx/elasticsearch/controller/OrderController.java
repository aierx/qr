package icu.aierx.elasticsearch.controller;

import icu.aierx.elasticsearch.base.CommonResult;
import icu.aierx.elasticsearch.entity.Order;
import icu.aierx.elasticsearch.repository.OrderRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */
@RestController
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("/order")
    public CommonResult getOrderById(@RequestParam("id") Long id){
        return CommonResult.SUCCESS(orderRepository.findById(id));
    }

    @PostMapping("order")
    public CommonResult insertOrder(@RequestBody @Validated Order order){
        return CommonResult.SUCCESS(orderRepository.save(order));
    }

}
