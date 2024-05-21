package com.example.checkit.service;

import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.UserLoginDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ClientService {
    ClientDto update(ClientDto clientDto);

    ClientDto findClientByEmail(String email);

    List<ClientDto> findAllClients();

    ClientDto findClientById(Long id);

    void delete(Long id);



}
