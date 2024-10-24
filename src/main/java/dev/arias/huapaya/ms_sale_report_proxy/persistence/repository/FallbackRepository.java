package dev.arias.huapaya.ms_sale_report_proxy.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class FallbackRepository {

    private final WebClient webClient;

    private final String uri;

    public FallbackRepository(WebClient webClient, @Value("${fallback.uri}") String uri) {
        this.webClient = webClient;
        this.uri = uri;
    }

    public Map<String, Object> getFallback() {
        Map<String, Object> response = new HashMap<>();
        response = this.webClient.get()
                .uri(this.uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {
                })
                .log()
                .block();
        return response;
    }

}
