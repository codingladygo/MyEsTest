package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

import static org.elasticsearch.action.admin.indices.stats.CommonStatsFlags.Flag.Search;

public class ESTest_Doc_Query {

    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200))
        );

//        //1、全量查询：查询索引中全部的数据
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        //2、条件查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30))); //查询条件
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        //3、分页查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //分页查询
//        builder.from(0);
//        builder.size(2);
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


//        //4、分页查询，并对查询结果进行排序
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //分页查询 (当前页码 - 1) * 每页显示条数
//        builder.from(2);
//        builder.size(2);
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        //5、查询排序
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //按照age进行排序
//        builder.sort("age", SortOrder.DESC);
////        //分页查询 (当前页码 - 1) * 每页显示条数
////        builder.from(2);
////        builder.size(2);
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        //6、过滤字段
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        //过滤字段，仅显示部分字段
//        String[] excludes = {};
//        String[] includes = {"name"};
//        builder.fetchSource(includes, excludes);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


//        //7、组合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("sex", "男"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 40));
//
//        builder.query(boolQueryBuilder);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        //8、范围查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
//
//        rangeQueryBuilder.gte(30);
//        rangeQueryBuilder.lt(50);
//
//        builder.query(rangeQueryBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


//        //8、模糊查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.query(QueryBuilders.fuzzyQuery("name", "王").fuzziness(Fuzziness.ONE));
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


//        //9、高亮查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "张三");
//
//        HighlightBuilder highlight = new HighlightBuilder();
//        highlight.preTags("<font color='red'>");
//        highlight.preTags("</font>");
//        highlight.field("name");
//
//
//        builder.highlighter(highlight);
//        builder.query(termQueryBuilder);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


//        //10、聚合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        AggregationBuilder aggregationsBuilder = AggregationBuilders.max("maxAge").field("age");
//
//        builder.aggregation(aggregationsBuilder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits()); //查询所有的数量
//        System.out.println(searchResponse.getTook()); //查询所有的结果
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        //11、分组查询
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user1");

        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        AggregationBuilder aggregationsBuilder = AggregationBuilders.terms("ageGroup").field("age");

        builder.aggregation(aggregationsBuilder);

        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();

        System.out.println(hits.getTotalHits()); //查询所有的数量
        System.out.println(searchResponse.getTook()); //查询所有的结果

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        esClient.close();

    }


}
