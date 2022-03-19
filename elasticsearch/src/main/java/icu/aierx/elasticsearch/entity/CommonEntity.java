package icu.aierx.elasticsearch.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Inheritance;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */
@Getter
@Setter
@Inheritance
public class CommonEntity {
    private String lastModifyBy;

    private String createBy;

    private String lastModifyDate;

    private String createDate;
}
