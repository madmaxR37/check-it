package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.ClientDto;
import com.example.checkit.dtos.DeliveryManDto;
import com.example.checkit.dtos.SellerDto;
import com.example.checkit.dtos.UserDto;
import com.example.checkit.models.Client;
import com.example.checkit.models.DeliveryMan;
import com.example.checkit.models.Seller;
import com.example.checkit.models.User;

public class UserMapper {

    public static User userDtoToUser(Object userDto){
        if (userDto instanceof ClientDto){
            return ClientMapper.clientDtoToClient((ClientDto) userDto);
        } else if (userDto instanceof SellerDto) {
            return SellerMapper.sellerDtoToSeller((SellerDto) userDto);
        } else if (userDto instanceof DeliveryManDto) {
            return DeliveryManMapper.deliveryManDtoToDeliveryMan((DeliveryManDto) userDto);
        }else return null;
    }
    public static UserDto userToUserDto(User user){
        if(user instanceof Client){
            return ClientMapper.clientToClientDto((Client) user);
    } else if (user instanceof Seller) {
            return SellerMapper.sellerToSellerDto((Seller) user);
        } else if (user instanceof DeliveryMan) {
            return DeliveryManMapper.deliveryManTODeliveryManDto((DeliveryMan) user);
        }else return null;
    }
    }
