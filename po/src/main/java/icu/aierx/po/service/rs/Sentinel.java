package icu.aierx.po.service.rs;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leiwenyong
 * @since 2022-09-04
 */
@Slf4j
public class Sentinel {
	public String userBlockHandler(String id){
		log.info(id);
		return "1";
	}
}
