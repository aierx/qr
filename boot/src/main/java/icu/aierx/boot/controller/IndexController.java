package icu.aierx.boot.controller;

import icu.aierx.boot.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leiwenyong
 * @since 2022-08-05
 */
@RestController
public class IndexController {
	
	@Autowired
	IndexController controller;
	
	@GetMapping("/index")
	@Validated
	public UserVO index(@RequestBody UserVO userVO){
		return controller.query(userVO);
	}
	
	
	private UserVO query(UserVO userVO){
		return userVO;
	}
	
}
