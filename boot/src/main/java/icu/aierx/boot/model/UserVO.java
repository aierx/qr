package icu.aierx.boot.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author leiwenyong
 * @since 2022-08-03
 */
@Data
public class UserVO {
	
	private Integer id;
	
	@NotBlank(message = "user is not null")
	private String username;
	
	@NotBlank(message = "密码不能为空")
	private String password;
}
