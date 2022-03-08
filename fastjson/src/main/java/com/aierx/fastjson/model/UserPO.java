package com.aierx.fastjson.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {
    @JSONField(name = "aaaaaaaaaaaa",ordinal = 1)
    private String username;
    @JSONField(ordinal = 0)
    private String password;
    @JSONField(ordinal = 2)
    private String userid;
    @JSONField(ordinal = 4)
    private String favorite;
    @JSONField(ordinal = 6)
    private String high;
    @JSONField(ordinal = 5)
    private String age;
    @JSONField(serialize=false)
    private BookPO bookPO;
    private List bookPOList;

//    @JSONField(format = "yyyy-MM-dd HH:mm:ss",ordinal = 10)
    private Date date;


    public UserPO(String lei, String wen, String yong, String hao, String ya) {
        this.username = lei;
        this.password = wen;
        this.userid = yong;
        this.high = hao;
        this.age = ya;
    }
}
