package com.aierx.jsr107.service;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceDiscovery {

    @NacosInjected
    NamingService namingService;

    @GetMapping("/nacos")
    public List<Instance> nacos(@RequestParam String name) throws NacosException {

       return   namingService.getAllInstances(name);


    }
}
