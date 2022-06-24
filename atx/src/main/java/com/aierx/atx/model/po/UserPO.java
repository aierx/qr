package com.aierx.atx.model.po;

import com.aierx.atx.common.CommonPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("user")
public class UserPO extends CommonPO implements Serializable {
    @Id
    String idd;

    @Field("une")
    private String username;
    @Field("pwd")
    private String password;

    public UserPO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
