package com.aierx.rocketmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {

    Object data;
    String msg;
    boolean status;

    public Results succeed(){
        Results results = new Results();
        results.status=true;
        return results;
    }

    public Results succeed(Object data){
        Results results = new Results();
        results.status=true;
        results.data = data;
        return results;
    }
}
