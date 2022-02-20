package com.aierx.atx.model.po;

import com.aierx.atx.common.CommonPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPO extends CommonPO {
    private String username;
    private String password;
}
