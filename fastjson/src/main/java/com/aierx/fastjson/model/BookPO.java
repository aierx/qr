package com.aierx.fastjson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookPO {

    private String booName;
    private Long age;

    public BookPO(String booName) {
        this.booName = booName;
    }
}
