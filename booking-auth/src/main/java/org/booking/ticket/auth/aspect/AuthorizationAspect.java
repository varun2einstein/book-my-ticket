package org.booking.ticket.auth.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.booking.ticket.auth.service.AuthService;
import org.booking.ticket.utils.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizationAspect {

    @Autowired
    private AuthService authService;

    @Before("@annotation(org.booking.ticket.auth.aspect.RequiresRole) && @annotation(requiresRole)")
    public void checkAuthorization(RequiresRole requiresRole) {
        String requiredRole = requiresRole.value();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!authService.hasRole(userDetails, requiredRole)) {
            throw new UnauthorizedException("User does not have the required role: " + requiredRole);
        }
    }
}
