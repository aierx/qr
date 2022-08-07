package icu.aierx.boot.controller;

import icu.aierx.boot.dao.UserDao;
import icu.aierx.boot.model.UserVO;
import icu.aierx.boot.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author leiwenyong
 * @since 2022-08-05
 */
@RestController
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
	
	@GetMapping("/l1")
	@Transactional
	public UserVO index1(@RequestBody @Validated UserVO userVO) throws InterruptedException, SQLException {
		Connection connection = dataSource.getConnection();
		userVO.setId(null);
		userDao.insert(userVO);
		Thread.sleep(1000);
		return userVO;
	}
	
	@GetMapping("/l2")
	public UserVO index2(@RequestBody UserVO userVO) {
		indexService2.show(null);
		return controller.query(userVO);
	}
	
	
	private UserVO query(UserVO userVO) {
		return userVO;
	}
	
}
