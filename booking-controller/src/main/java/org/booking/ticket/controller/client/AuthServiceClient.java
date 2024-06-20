package org.booking.ticket.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "http://auth-service-url")
public interface AuthServiceClient {

    @PostMapping("/api/auth/validate")
    ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token);
}
