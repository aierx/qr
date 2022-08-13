package com.aierx.boot.config;

import lombok.Getter;
import lombok.Setter;
import org.redisson.api.RLock;

@Setter
@Getter
public class LockResult {
 
    private LockResultStatus lockResultStatus;
 
    private RLock rLock;
}