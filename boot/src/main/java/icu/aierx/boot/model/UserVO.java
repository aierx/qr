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
	
	@NotNull(message = "id is not null")
	private Integer id;
	
	@NotBlank(message = "user is not null")
	private String username;
}
