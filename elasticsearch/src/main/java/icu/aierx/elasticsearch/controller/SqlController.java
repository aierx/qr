package icu.aierx.elasticsearch.controller;

import icu.aierx.elasticsearch.base.CommonResult;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

import static org.elasticsearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;

/**
 * 同步数据到ES
 *
 * @author leiwenyong
 * @since 2022/3/17
 */
@RestController("/")
public class SqlController {


    /**
     * 使用同步操作进行数据库和ES进行同步
     *
     * @param sql sql语句
     * @param entity 指定表结构
     * @return 同步是否成功
     */
    @PostMapping("/sql")
    public CommonResult pushTOESBySql(@RequestParam("sql")String sql,@RequestParam("entity")String entity){
        return CommonResult.SUCCESS("ok");
    }

    @Autowired
    RestHighLevelClient highLevelClient;

    @GetMapping("/t")
    public CommonResult getFlightDetail() throws IOException {
        HashMap<String, String> param = new HashMap<>();
        param.put("username","leiwenyong");
        IndexRequest request = new IndexRequest("spring-data")
                .id("10086")
                .source(param)
                .setRefreshPolicy(IMMEDIATE);
        IndexResponse response = highLevelClient.index(request, RequestOptions.DEFAULT);
        return CommonResult.SUCCESS(response);
    }

}
