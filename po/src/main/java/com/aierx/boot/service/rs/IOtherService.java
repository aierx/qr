package com.aierx.boot.service.rs;

import com.aierx.boot.aop.Valid;
import com.aierx.boot.model.po.UserPO;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
public interface IOtherService {
	public void otherFun(@Valid UserPO userPO);
}
