package com.aierx.jsr107.model.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    int id;
    int version;
    String status;
    String reviewer;
    String username;
    String password;

    List<UserDetail> userDetails;
}
