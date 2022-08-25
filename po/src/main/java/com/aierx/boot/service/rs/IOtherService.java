package com.aierx.boot.service.rs;

import com.aierx.boot.model.po.UserPO;

import javax.validation.constraints.NotNull;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
public interface IOtherService {
	void otherFun(@NotNull UserPO userPO);
	
	void updateData(String decisionId,UserPO userPO);
}
