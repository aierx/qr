package com.aierx.jsr303.model.po;

import com.aierx.jsr303.validate.B;
import com.aierx.jsr303.validate.VersionCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@VersionCheck(groups = {B.class})
public class DecisionPO {
    public int id;
    @NotNull(message = "没有名字",groups = {B.class})
    public String name;
    public int version;
}


