import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */
@Slf4j
public class Test1 {
    RestHighLevelClient client;

    @Before
    public void before(){
        client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
    }
    @After
    public void after()throws Exception{
        client.close();
    }

    /**
     * 索引操作
     * @throws Exception 异常
     */
    @Test
    public void esTest1()throws Exception{
//        创建索引
//        CreateIndexRequest request = new CreateIndexRequest("user");
//        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
//        System.out.println(response.isAcknowledged());

//        查询索引
//        GetIndexRequest user = new GetIndexRequest("user");
//        GetIndexResponse response = client.indices().get(user, RequestOptions.DEFAULT);
//        System.out.println(response.getAliases());
//        System.out.println(response.getMappings());
//        System.out.println(response.getSettings());

//        删除索引
        DeleteIndexRequest request = new DeleteIndexRequest("user");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }


    /**
     * 插入数据
     * @throws Exception 异常
     */
    @Test
    public void esTest2()throws Exception{
        IndexRequest request = new IndexRequest();
        request.index("user").id("1004");
        User user = new User("zhangsan","男",30);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(user);
        request.source(value, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 更新数据
     * @throws Exception 异常
     */
    @Test
    public void esTest3()throws Exception{
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1005");
        request.doc(XContentType.JSON,"age",30);
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 查询数据
     * @throws Exception 查询
     */
    @Test
    public void  exTest4()throws Exception{
        GetRequest request = new GetRequest();
        request.index("user").id("1001");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
    }

    /**
     * 删除数据
     * @throws Exception 删除
     */
    @Test
    public void esTest5()throws Exception{
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 批量增加
     * @throws Exception 批量增加
     */
    @Test
    public void esTest6()throws Exception{
        BulkRequest request = new BulkRequest();
        request.add( new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","张三","age",20,"sex","男"));
        request.add( new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","李四","age",10,"sex","女"));
        request.add( new IndexRequest().index("user").id("1004").source(XContentType.JSON,"name","王五","age",27,"sex","男"));
        request.add( new IndexRequest().index("user").id("1005").source(XContentType.JSON,"name","赵六1","age",40,"sex","女"));
        request.add( new IndexRequest().index("user").id("1006").source(XContentType.JSON,"name","赵六2","age",30,"sex","男"));
        request.add( new IndexRequest().index("user").id("1007").source(XContentType.JSON,"name","赵六3","age",50,"sex","女"));

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());
    }

    /**
     * 批量删除
     * @throws Exception 批量删除
     */
    @Test
    public void esTest7()throws Exception{
        BulkRequest request = new BulkRequest();
        request.add( new DeleteRequest().index("user").id("1002"));
        request.add( new DeleteRequest().index("user").id("1003"));
        request.add( new DeleteRequest().index("user").id("1004"));

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());
    }


    /**
     * 查询
     * @throws Exception 查询
     */
    @Test
    public void esTest8()throws Exception{
        SearchRequest request = new SearchRequest();
        request.indices("user");
//        查询全部
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        字段查询
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.termQuery("age",20));
//        分页查询 排序 过滤
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        query.from(2);
//        query.size(4);
//        query.sort("age", SortOrder.DESC);
//        String[] excludes = {};
//        String[] includes = {"name"};
//        query.fetchSource(includes,excludes);
//        组合查询
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",40));
//        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
//        SearchSourceBuilder query = new SearchSourceBuilder().query(boolQueryBuilder);
//        范围查询
//        RangeQueryBuilder boolQueryBuilder = QueryBuilders.rangeQuery("age");
//        boolQueryBuilder.gte(20);
//        boolQueryBuilder.lte(40);
//        SearchSourceBuilder query = new SearchSourceBuilder().query(boolQueryBuilder);
//        模糊查询
//        FuzzyQueryBuilder boolQueryBuilder = QueryBuilders.fuzzyQuery("name","zhansan").fuzziness(Fuzziness.ONE);
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(boolQueryBuilder);
//        高亮查询
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermQueryBuilder termQuery = QueryBuilders.termQuery("name", "zhaoliu");
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//        builder.highlighter(highlightBuilder);
//        builder.query(termQuery);
//        聚合查询
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        MaxAggregationBuilder maxAggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        builder.aggregation(maxAggregationBuilder);
//        分组查询
        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("maxAge").field("age");
        builder.aggregation(aggregationBuilder);

        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getHits().getTotalHits().value);
        for (SearchHit fields : response.getHits().getHits()) {
            log.info(fields.getSourceAsString());
        }
    }

}
