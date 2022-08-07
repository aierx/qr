package icu.aierx.boot.service;

import javax.validation.constraints.NotBlank;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
public interface IIndexService {
	
	void show(@NotBlank String decisionId);
	
}
