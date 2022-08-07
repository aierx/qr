package com.aierx.boot.model.po;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author leiwenyong
 * @since 2022-08-07
 */
@Data
public class CC {
	
	@NotBlank
	String username;
}
