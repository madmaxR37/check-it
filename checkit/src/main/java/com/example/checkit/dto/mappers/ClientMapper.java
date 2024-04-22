package com.example.checkit.dto.mappers;

import com.example.checkit.dto.ClientDto;
import com.example.checkit.model.Client;

public class ClientMapper {
    public static Client clientDtoToClient(ClientDto clientDto){
        return (Client) new Client()
                .setFirstname(clientDto.getFirstname())
                .setSurname(clientDto.getSurname())
                .setPhoneNumber(clientDto.getPhoneNumber())
                .setActiveStatus(clientDto.getActiveStatus())
                .setAccountBalance(clientDto.getAccountBalance())
                .setRole(clientDto.getRole())
                .setProfileUrl(clientDto.getProfileUrl());

    }

    public static ClientDto clientToClientDto(Client client){
        return (ClientDto) new ClientDto()
                .setFirstname(client.getFirstname())
                .setSurname(client.getSurname())
                .setPhoneNumber(client.getPhoneNumber())
                .setActiveStatus(client.getActiveStatus())
                .setAccountBalance(client.getAccountBalance())
                .setRole(client.getRole())
                .setProfileUrl(client.getProfileUrl());
    }

    //TODO map the address,litigation and cards
}
