package com.cliente.rest.server;

import com.cliente.rest.model.AuthResponse;
import com.cliente.rest.model.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/mock")
public class MockApiController {

    // Endpoint de Login (Público)
    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        // Validación simulada
        if ("admin".equals(request.getUsername()) && "1234".equals(request.getPassword())) {
            // Token falso
            String fakeJwt = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." + UUID.randomUUID().toString();
            return ResponseEntity.ok(new AuthResponse(fakeJwt));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // Endpoint Protegido (Requiere Token)
    @GetMapping("/productos")
    public ResponseEntity<String> obtenerProductos(@RequestHeader("Authorization") String authHeader) {
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error: No enviaste el Token JWT");
        }
        
        return ResponseEntity.ok("[{\"id\": 1, \"nombre\": \"Laptop Gamer\"}, {\"id\": 2, \"nombre\": \"Mouse RGB\"}]");
    }
}