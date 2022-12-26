package icu.aierx.boot.controller;

import icu.aierx.boot.dao.UserDao;
import icu.aierx.boot.model.PageVO;
import icu.aierx.boot.model.UserVO;
import icu.aierx.boot.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022-08-05
 */
@RestController
@CrossOrigin
public class IndexController {
	
	@Autowired
	IndexController controller;
	
	@Autowired
	UserDao userDao;
	
	@Resource(name = "l1")
	IIndexService indexService1;
	
	@Resource(name = "l2")
	IIndexService indexService2;
	@Autowired
	DataSource dataSource;
	
	@PostMapping("/user")
	@Transactional
	@CrossOrigin
	public UserVO index1(@RequestBody @Validated UserVO userVO) throws InterruptedException, SQLException {
		userDao.insert(userVO);
		return userVO;
	}
	
	@GetMapping("/l2")
	@CrossOrigin
	public UserVO index2(@RequestBody UserVO userVO) {
		indexService2.show("222");
		List<UserVO> userVOS = userDao.selectAll(new PageVO(1, 10));
		return userVOS.get(userVO.getId());
	}
	
	@GetMapping("/user")
	@CrossOrigin
	public UserVO queryUserByName(@RequestParam String username){
		UserVO userVO = userDao.queryByUserName(username);
		return userVO;
	}
	
}
