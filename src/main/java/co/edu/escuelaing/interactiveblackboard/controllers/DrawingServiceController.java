/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.interactiveblackboard.controllers;

import co.edu.escuelaing.interactiveblackboard.repositories.TicketRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DrawingServiceController {
    
    @GetMapping("/status")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. " +
                java.time.LocalDate.now() + ", " +
                java.time.LocalTime.now() +
                ". " + "The server is Runnig!\"}";
    }
    
    @GetMapping("/getticket")
    public String getTicket() {
        return "{\"ticket\":\""+
                TicketRepository.getInstance().getTicketNumber() + "\"}";
    }
    
    @GetMapping("/getusername")
    public String getUserName() {
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();
        UserDetails user = (UserDetails) auth.getPrincipal();
        return "{\"user\":\""+
                user.getUsername() + "\"}";
    }
    
}