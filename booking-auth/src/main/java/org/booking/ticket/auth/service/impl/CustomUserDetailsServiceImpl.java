package org.booking.ticket.auth.service.impl;

import org.booking.ticket.auth.service.CustomUserDetailsService;
import org.booking.ticket.model.Customer;
import org.booking.ticket.model.UserRole;
import org.booking.ticket.service.CustomerService;
import org.booking.ticket.utils.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements  CustomUserDetailsService {

    private CustomerService customerService;

    public CustomUserDetailsServiceImpl( CustomerService customerService){
        this.customerService = customerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = customerService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                Arrays.asList(new SimpleGrantedAuthority(user.getRoles().stream().map(UserRole::name).collect(Collectors.joining(","))))
        );
    }

    @Override
    public void saveCustomer(Customer customer) throws UserAlreadyExistsException {
        Customer user = customerService.findByUsername(customer.getEmail());
        if (user == null) {
            customerService.saveCustomer(user);
        } else {
            throw new UserAlreadyExistsException(" User already exists ");
        }
    }
}
