package com.aierx.config.entity;

/**
 * @author leiwenyong
 * @since 2022/3/13
 */
public class Properties {
    private Integer id;

    private String name;

    public Properties(Integer id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}