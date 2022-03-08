package com.aierx.fastjson;

import com.aierx.fastjson.model.BookPO;
import com.aierx.fastjson.model.UserPO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPatch;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class TestJson {
    @Test
    public void TestJson1(){
        UserPO userPO = new UserPO("lei", "wen", "yong", "hao", "ya");
        BookPO bookPO = new BookPO("后裔");
        userPO.setBookPO(bookPO);
        userPO.setDate(new Date());
        String s = JSON.toJSONString(userPO
                ,SerializerFeature.PrettyFormat // 格式化文档
//                ,SerializerFeature.DisableCircularReferenceDetect // 禁用循环引用
//                ,SerializerFeature.WriteMapNullValue // 输出空值
//                ,SerializerFeature.WriteNullNumberAsZero // 数字类型为零
//                ,SerializerFeature.WriteNullListAsEmpty // 集合类型输出[]
//                ,SerializerFeature.WriteNullStringAsEmpty
//                ,SerializerFeature.UseSingleQuotes
//                ,SerializerFeature.UseISO8601DateFormat

        );

        UserPO userPO1 = JSON.parseObject(s, UserPO.class);
        System.out.println(s);
    }

    @Test
    public void testJsonPath(){
        //language=JSON
        String jsonStr = "{\n" +
                "    \"store\": {\n" +
                "        \"bicycle\": {\n" +
                "            \"color\": \"red\",\n" +
                "            \"price\": 19.95\n" +
                "        },\n" +
                "        \"book\": [\n" +
                "            {\n" +
                "                \"author\": \"刘慈欣\",\n" +
                "                \"price\": 28.95,\n" +
                "                \"category\": \"科幻\",\n" +
                "                \"title\": \"三体\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"author\": \"itguang\",\n" +
                "                \"price\": 12.99,\n" +
                "                \"category\": \"编程语言\",\n" +
                "                \"title\": \"go语言实战\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        Object eval = JSONPath.eval(jsonObject, "$.store.bicycle['color','price']");
        System.out.println(eval);
    }

    @Test
    public void  testJsonK(){
        UserPO userPO = new UserPO("lei", "wen", "yong", "hao", "ya");
        BookPO bookPO = new BookPO("后裔");
        userPO.setBookPO(bookPO);
        userPO.setDate(new Date());
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteDateUseDateFormat.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.PrettyFormat.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteMapNullValue.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullListAsEmpty.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullStringAsEmpty.getMask();
        String s = JSON.toJSONString(userPO);
        System.out.println(s);
    }
}
