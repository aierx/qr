package icu.aierx.po.service.rs;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import icu.aierx.po.model.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022-09-04
 */

@Service
@Slf4j
public class SentinelService {
	
	public UserPO getUser(String id){
		if (id.equals("0000")){
			throw  new RuntimeException();
		}
		return new UserPO("1","2","3","4");
	}
	
	
}
