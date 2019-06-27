package com.esfirst.config;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.esfirst.Repo")
@ComponentScan(basePackages = { "com.esfirst.model.resourcess" })
public class ElasticConfiguration {
 
    @Value("${elasticsearch.home:C:\\elasticsearch-7.1.1}")
    private String elasticsearchHome;
 
    @Value("${elasticsearch.cluster.name:elasticsearch}")
    private String clusterName;
 
    @Bean
    public TransportClient client() throws UnknownHostException {
        Settings elasticsearchSettings = Settings.builder()
          .put("client.transport.sniff", true)
          .put("path.home", elasticsearchHome)
          .put("cluster.name","elasticsearch").build();
        @SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		return client;
    }
 
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
//        return new ElasticsearchTemplate(client());
//    }
}
