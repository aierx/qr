package com.aierx.boot.service.rs;

import com.aierx.boot.aop.Valid;
import com.aierx.boot.dao.UserDao;
import com.aierx.boot.model.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * @author leiwenyong
 * @since 2022/4/19
 */
@Service
@Validated
public class OtherService implements IOtherService {
	
	@Autowired
	UserDao userDao;
	
	@Transactional(rollbackFor = Exception.class)
	public void otherFun(@Valid UserPO userPO) {
		if (userPO.getUserId().equals("10086")) {
			return;
		} else {
			userPO.setUserId("100");
		}
		if (userPO.getUserAge().equals("30")) {
			userPO.setUserId("111");
		}
		userPO.setUserName("other");
		
		
	}
	
}
