package icu.aierx.po.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import icu.aierx.po.model.po.UserPO;
import icu.aierx.po.service.rs.SentinelService;
import ixcu.aierx.api.provider.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leiwenyong
 * @since 2022-09-04
 */
@RestController
@Slf4j
public class sentinelController {
	
	@Autowired
	SentinelService sentinelService;
	
	@Reference(protocol = "dubbo")
	UserService userService;
	
	@GetMapping("/u/{id}")
	@SentinelResource(value = "user",blockHandler = "thisBlockHandler",fallback = "thisFallBack")
	public UserPO getUser(@PathVariable("id")String id){
		userService.add(10,10);
		return sentinelService.getUser(id);
	}
	
	public UserPO thisBlockHandler(String id, BlockException exception){
		log.error(id);
		return new UserPO("请稍后在世","","","");
	}
	public UserPO thisFallBack(String id, Exception exception){
		log.error(id);
		return new UserPO("请稍后在世","","","");
	}

}
