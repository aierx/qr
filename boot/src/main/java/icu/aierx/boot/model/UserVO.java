package icu.aierx.boot.model;

import icu.aierx.boot.validate.NAN;
import icu.aierx.boot.validate.ValidateGroup;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author leiwenyong
 * @since 2022-08-03
 */
@Data
public class UserVO {
	
	@NotBlank(message = "id is not null",groups = {ValidateGroup.Insert.class})
	private String id;
	
	@NAN(message = "hello world",groups = {ValidateGroup.Select.class})
	private String user;
	
	@Valid
	@NotNull(message = "aaa")
	private LevelVO levelVO;
}
