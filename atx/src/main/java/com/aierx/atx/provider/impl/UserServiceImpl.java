package com.aierx.atx.provider.impl;

import ixcu.aierx.api.provider.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author leiwenyong
 * @since 2022-09-04
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Override
	public int add(int a, int b) {
		log.info("begin add.");
		return a+b;
	}
}
