package com.cliente.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private ApiConsumerService apiService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=========================================");
        System.out.println("INICIANDO CLIENTE REST AUTOMATIZADO");
        System.out.println("=========================================");

        // Intentamos Login
        System.out.println("Intentando autenticación con usuario 'admin'...");
        String token = apiService.loginYObtenerToken("admin", "1234");

        if (token != null) {
            System.out.println("✅ Login Exitoso.");
            System.out.println("🔑 Token JWT Recibido: " + token);
            
            // Intentamos consumir datos protegidos
            System.out.println("\nConsultando endpoint protegido /productos...");
            String datos = apiService.obtenerDatosProtegidos(token);
            
            System.out.println("📦 Datos recibidos del servidor:");
            System.out.println(datos);
        } else {
            System.out.println("❌ Falló el login.");
        }
        
        System.out.println("=========================================");
    }
}