package com.example.checkit.dto.mappers;

import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.DeliveryManDto;
import com.example.checkit.dto.SellerDto;
import com.example.checkit.dto.UserDto;
import com.example.checkit.model.Client;
import com.example.checkit.model.DeliveryMan;
import com.example.checkit.model.Seller;
import com.example.checkit.model.User;

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
