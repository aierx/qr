package com.aierx.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class TestService {
 
    @Resource
    private LockManager lockManager;
 
    public String test(String userId) {
        // 锁：userId, 锁超时时间：5s, 锁等待时间：50ms
        LockResult lockResult = lockManager.lock(userId, 5000, 50);
 
        try {
            //  业务代码
        } finally {
            lockManager.unlock(lockResult.getRLock());
        }
 
        return "";
    }
}