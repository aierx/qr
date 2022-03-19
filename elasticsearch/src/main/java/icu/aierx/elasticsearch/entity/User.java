package icu.aierx.elasticsearch.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */
@Entity
@Table(name="db_user")
@Getter
@Setter
public class User extends CommonEntity{
    @Id
    @GeneratedValue
    private Long userId;
@NotNull(message = "用户名不能为空")
    private String userName;
@NotNull(message = "年龄不能为空")
    private String userAge;
@NotNull(message = "密码不能为空")
    private String userPassword;
}
