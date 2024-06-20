package org.booking.ticket.auth.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    // This method should check if the given user has the required role
    boolean hasRole(UserDetails userDetails, String role);
}
