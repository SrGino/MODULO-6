package com.cliente.rest.client;

import com.cliente.rest.model.AuthResponse;
import com.cliente.rest.model.LoginRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiConsumerService {

    private final RestTemplate restTemplate;
    // URL base del servidor mock (mismo localhost)
    private final String BASE_URL = "http://localhost:8090/api/mock";

    public ApiConsumerService() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Autenticarse y obtener el Token
     */
    public String loginYObtenerToken(String usuario, String password) {
        String url = BASE_URL + "/auth/login";
        
        LoginRequest loginRequest = new LoginRequest(usuario, password);
        HttpEntity<LoginRequest> entity = new HttpEntity<>(loginRequest);

        try {
            ResponseEntity<AuthResponse> response = restTemplate.postForEntity(url, entity, AuthResponse.class);
            
            if (response.getBody() != null) {
                return response.getBody().getToken();
            }
        } catch (Exception e) {
            System.err.println("Error en login: " + e.getMessage());
        }
        return null;
    }

    /**
     * Consumir endpoint protegido usando el Token
     */
    public String obtenerDatosProtegidos(String jwtToken) {
        String url = BASE_URL + "/productos";

        // Creamos los Headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (Exception e) {
            return "Error consumiendo API: " + e.getMessage();
        }
    }
}