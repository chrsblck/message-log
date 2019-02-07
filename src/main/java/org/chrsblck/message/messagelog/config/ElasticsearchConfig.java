package org.chrsblck.message.messagelog.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.chrsblck.message.messagelog.repository")

@SuppressWarnings("unused")
public class ElasticsearchConfig {

    @Autowired
    ElasticsearchProperties elasticsearchProperties;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client() {
        return new RestHighLevelClient(
                        RestClient.builder(new HttpHost(elasticsearchProperties.getHost(), elasticsearchProperties.getPort())));
    }

    @Primary
    @Bean("elasticsearchTemplate")
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        return new ElasticsearchRestTemplate(client());
    }

}
