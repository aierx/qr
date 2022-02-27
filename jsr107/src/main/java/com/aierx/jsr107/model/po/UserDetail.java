package com.aierx.jsr107.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {
    int id;
    int userId;
    String desc;
    List<UserDetailDesc> userDetailDescs;
}
