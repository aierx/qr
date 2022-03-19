package icu.aierx.elasticsearch.controller;

import icu.aierx.elasticsearch.base.CommonResult;
import icu.aierx.elasticsearch.entity.User;
import icu.aierx.elasticsearch.repository.UserRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */
@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public CommonResult getUserById(@RequestParam("id")Long id){
        return CommonResult.SUCCESS( userRepository.findById(id));
    }

    @PostMapping("/user")
    public CommonResult insertUser(@RequestBody @Validated User user){
        User saveUser = userRepository.save(user);
        return CommonResult.SUCCESS(saveUser);
    }
}
