package com.example.checkit.dto.mappers;

import com.example.checkit.dto.ClientDto;
import com.example.checkit.model.Client;

public class ClientMapper {


    public static Client clientDtoToClient(ClientDto clientDto){

        return (Client) new Client()
                .setCards(CardMapper.cardDtosToCards(clientDto.getCardDtos()))
                .setFirstname(clientDto.getFirstname())
                .setSurname(clientDto.getSurname())
                .setPhoneNumber(clientDto.getPhoneNumber())
                .setActiveStatus(clientDto.getActiveStatus())
                .setAccountBalance(clientDto.getAccountBalance())
                .setRole(clientDto.getRole())
                .setProfileUrl(clientDto.getProfileUrl())
                .setAddress(AddressMapper.addressDtoToAddress(clientDto.getAddressDto()))
                ;

    }

    public static ClientDto clientToClientDto(Client client){
        return (ClientDto) new ClientDto()
                .setCardDtos(CardMapper.cardsToCardDtos(client.getCards()))
                .setCreatedDate(client.getCreatedDate())
                .setFirstname(client.getFirstname())
                .setId(client.getId())
                .setSurname(client.getSurname())
                .setPhoneNumber(client.getPhoneNumber())
                .setActiveStatus(client.getActiveStatus())
                .setAccountBalance(client.getAccountBalance())
                .setRole(client.getRole())
                .setProfileUrl(client.getProfileUrl())
                .setAddressDto(AddressMapper.addressToAddressDto(client.getAddress()))
                ;
    }
}
