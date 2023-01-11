package icu.aierx.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
@Service("l1")
@Slf4j
public class IndexService1 implements IIndexService {
	public IndexService1() {
		log.error("construct");
	}
	
	@Override
	public void show(String decisionId) {
		System.out.println(decisionId);
	}
}
