package org.booking.ticket.auth.service.impl;

import org.booking.ticket.auth.service.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    // This method should check if the given user has the required role
    @Override
    public boolean hasRole(UserDetails userDetails, String role) {
        return userDetails.getAuthorities().stream()
            .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));
    }
}
