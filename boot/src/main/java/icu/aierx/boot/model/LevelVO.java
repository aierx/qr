package icu.aierx.boot.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author leiwenyong
 * @since 2022-08-06
 */
@Data
public class LevelVO {
	
	@NotBlank(message = "不能为空")
	private String levelName;
	
	
}
