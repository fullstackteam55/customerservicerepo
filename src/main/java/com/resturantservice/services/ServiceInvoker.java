package com.resturantservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.resturantservice.entities.*;

@Service
public class ServiceInvoker {

    @Autowired
    private WebClient.Builder webClientBuilder;
    
    @Autowired
    private RestTemplate restTemplate;

    public User getUser(String username) {
        WebClient webClient = webClientBuilder.build();
        return webClient.get()
            .uri("http://localhost:9091/userservices/users" + username) // Replace with your URL
            .retrieve()
            .bodyToMono(User.class)
            .block(); // Use block() for synchronous call, avoid in reactive services
    }
    
    public String login(User loginUser) {
    	String url = "http://localhost:9091/userservices/users/login";
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> requestEntity = new HttpEntity<>(loginUser, headers);

        return restTemplate.postForObject(url, requestEntity, String.class);
    }
}

