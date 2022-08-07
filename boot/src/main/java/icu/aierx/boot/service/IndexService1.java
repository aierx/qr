package icu.aierx.boot.service;

import org.springframework.stereotype.Service;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
@Service("l1")
public class IndexService1 implements IIndexService {
	@Override
	public void show(String decisionId) {
		System.out.println(decisionId);
	}
}
