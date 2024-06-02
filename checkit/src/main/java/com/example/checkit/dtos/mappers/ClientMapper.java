package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.ClientDto;
import com.example.checkit.models.Client;

public class ClientMapper {


    public static Client clientDtoToClient(ClientDto clientDto){

        return (Client) new Client()
                .setFirstname(clientDto.getFirstname())
                .setLast_name(clientDto.getSurname())
                .setPhoneNumber(clientDto.getPhoneNumber())
                .setEmail(clientDto.getEmail())
                .setProfileUrl(clientDto.getProfileUrl())
                .setAddress(AddressMapper.addressDtoToAddress(clientDto.getAddressDto()));

    }

    public static ClientDto clientToClientDto(Client client){
          ClientDto clientDto = (ClientDto) new ClientDto()
                .setCreatedDate(client.getCreatedDate())
                .setFirstname(client.getFirstname())
                .setId(client.getId())
                .setEmail(client.getEmail())
                .setSurname(client.getLast_name())
                .setPhoneNumber(client.getPhoneNumber())
                .setActiveStatus(client.getActiveStatus())
                .setRole(client.getRole())
                .setProfileUrl(client.getProfileUrl())
                .setAccountBalance(client.getAccountBalance())
                .setAddressDto(AddressMapper.addressToAddressDto(client.getAddress()));

          if (!client.getCarts().isEmpty()){
              clientDto.setCartDtos(CartMapper.cartsToCartDtos(client.getCarts()));
          }
          return clientDto;
    }
}
