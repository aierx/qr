package icu.aierx.po.model.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class UserPO {
    
    public interface Second{}
    
    public interface first{}

    public UserPO(String userName, String userPassword, String userId, String userAge) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userId = userId;
        this.userAge = userAge;
    }

    @NotBlank(message = "用户名不能为空",groups = {FunctionalInterface.class})
    private String userName;
    @NotNull(message = "密码不能为空",groups = {FunctionalInterface.class})
    private String userPassword;

    private String userId;
    @NotNull
    private String userAge;
}
