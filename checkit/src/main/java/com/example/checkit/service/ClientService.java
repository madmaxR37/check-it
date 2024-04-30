package com.example.checkit.service;

import com.example.checkit.dto.CardDto;
import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.LitigationDto;
import com.example.checkit.dto.TransactionDto;

import java.util.List;

public interface ClientService {
    ClientDto create(ClientDto clientDto);

    ClientDto update(ClientDto clientDto);

    ClientDto findClientByEmail(String email);

    List<ClientDto> findAllClients();

    ClientDto findClientById(Long id);

    void delete(Long id);



}
