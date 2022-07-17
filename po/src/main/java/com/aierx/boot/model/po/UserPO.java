package com.aierx.boot.model.po;

import com.aierx.boot.common.CommonPO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class UserPO  extends CommonPO {

    public UserPO(String userName, String userPassword, String userId, String userAge) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userId = userId;
        this.userAge = userAge;
    }

    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "密码不能为空")
    private String userPassword;

    private String userId;

    private String userAge;
}
