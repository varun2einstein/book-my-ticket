package org.booking.ticket.controller;

import org.booking.ticket.auth.config.AuthSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan( basePackages = {"org.booking.ticket", "org.booking.ticket.dao.repository", "org.booking.ticket.utils.logging", "org.booking.ticket.utils.exception"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = AuthSecurityConfig.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = SecurityAutoConfiguration.class)})
@EnableMongoRepositories(basePackages = "org.booking.ticket.dao.repository")
@EnableAspectJAutoProxy
public class TicketBookingControllerApp {
    public static void main(String[] args) {
        SpringApplication.run(TicketBookingControllerApp.class, args);
    }
}