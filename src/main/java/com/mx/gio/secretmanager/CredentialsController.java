package com.mx.gio.secretmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CredentialsController {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @GetMapping("/credentials")
    public ResponseEntity<Map<String, String>> get() {

        Map<String, String> credentials = new HashMap<>();
        credentials.put("spring.datasource.username", username);
        credentials.put("spring.datasource.password", password);
        credentials.put("spring.datasource.url", url);


        return ResponseEntity.ok(credentials);
    }
}