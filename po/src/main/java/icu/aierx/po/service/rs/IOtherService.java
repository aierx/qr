package icu.aierx.po.service.rs;

import icu.aierx.po.model.po.UserPO;

import javax.validation.constraints.NotNull;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
public interface IOtherService {
	void otherFun(@NotNull UserPO userPO);
	
	void updateData(String decisionId,UserPO userPO);
}
