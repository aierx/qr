package com.aierx.boot.model.po;

import com.aierx.boot.common.CommonPO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@NoArgsConstructor
public class UserPO  extends CommonPO {
    
    public interface Second{}
    
    public interface first{}

    public UserPO(String userName, String userPassword, String userId, String userAge) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userId = userId;
        this.userAge = userAge;
    }
    
    @Valid
    @NotNull
    CC a;
    
    List<CC> cc;

    @NotBlank(message = "用户名不能为空",groups = {FunctionalInterface.class})
    private String userName;
    @NotNull(message = "密码不能为空",groups = {FunctionalInterface.class})
    private String userPassword;

    private String userId;
    @NotNull
    private String userAge;
}
