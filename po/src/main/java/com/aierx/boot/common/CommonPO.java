package com.aierx.boot.common;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommonPO {
    public int id;
    @NotNull(message = "version不能为空")
    public int version;
    
    @NotNull(message = "userAge1不能为空")
    private String userAge1;
}
