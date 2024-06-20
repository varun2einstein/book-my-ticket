package org.booking.ticket.auth.service;

import org.booking.ticket.model.Customer;
import org.booking.ticket.utils.exception.UserAlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService extends UserDetailsService {
    void saveCustomer(Customer customer) throws UserAlreadyExistsException;
}
