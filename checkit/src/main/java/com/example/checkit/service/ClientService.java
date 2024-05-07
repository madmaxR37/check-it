package com.example.checkit.service;

import com.example.checkit.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto create(ClientDto clientDto);

    ClientDto update(ClientDto clientDto);

    ClientDto findClientByEmail(String email);

    List<ClientDto> findAllClients();

    ClientDto findClientById(Long id);

    void delete(Long id);



}
