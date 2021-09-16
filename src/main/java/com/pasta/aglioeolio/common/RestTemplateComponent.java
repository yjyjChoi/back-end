package com.pasta.aglioeolio.common;

import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateComponent {

    private final RestTemplate restTemplate;

    public RestTemplateComponent( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity get( String url, HttpHeaders httpHeaders ) {
        return callApiEndpoint( url, HttpMethod.GET, httpHeaders, null, (Class)Object.class );
    }

    public ResponseEntity get( String url, HttpHeaders httpHeaders, Class clazz ) {
        return callApiEndpoint( url, HttpMethod.GET, httpHeaders, null, clazz );
    }

    public ResponseEntity post( String url, HttpHeaders httpHeaders, Map body ) {
        return callApiEndpoint( url, HttpMethod.POST, httpHeaders, body,(Class)Object.class );
    }

    public ResponseEntity post( String url, HttpHeaders httpHeaders, Map body, Class clazz ) {
        return callApiEndpoint( url, HttpMethod.POST, httpHeaders, body, clazz );
    }

    private ResponseEntity callApiEndpoint( String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Map body, Class clazz ) {
        return restTemplate.exchange( url, httpMethod, new HttpEntity<>(body, httpHeaders), clazz );
    }

}