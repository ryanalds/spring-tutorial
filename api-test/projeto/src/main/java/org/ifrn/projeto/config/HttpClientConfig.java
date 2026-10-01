package org.ifrn.projeto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration 
public class HttpClientConfig {

    @Bean 
    RestClient simpsonsClient(@Value("${simpsons.api.url}") String baseUrl ){
        return RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
    
}
