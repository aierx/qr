package icu.aierx.boot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
@Service("l2")
@Validated
public class IndexService2 implements IIndexService {
	
	@Override
	public void show(String decisionId) {
		System.out.println(decisionId);
	}
}
