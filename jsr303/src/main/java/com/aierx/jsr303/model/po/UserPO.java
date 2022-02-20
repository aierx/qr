package com.aierx.jsr303.model.po;

import com.aierx.jsr303.validate.A;
import com.aierx.jsr303.validate.B;
import com.aierx.jsr303.validate.VersionCheck;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {
    public int id;
    @NotBlank(groups = {B.class},message = "不能为空")
    public String status;
    @NotBlank(groups = {A.class},message = "aaaaaaaaaaa")
    public String reviewer;
    public String username;
    @VersionCheck(groups = {B.class})
    public String password;
    public int version;
}
