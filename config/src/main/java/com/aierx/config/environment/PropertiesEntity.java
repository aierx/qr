package com.aierx.config.environment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertiesEntity {
    private int id;
    private String name;
    private String value;
}
