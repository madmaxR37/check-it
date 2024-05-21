package com.example.checkit.service.serviceImplementation;
import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.UserLoginDto;
import com.example.checkit.dto.mappers.ClientMapper;
import com.example.checkit.model.Client;
import com.example.checkit.repository.*;
import com.example.checkit.service.ClientService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }



    @Override
    public ClientDto update(ClientDto clientDto) {

        Client clientModel = ClientMapper.clientDtoToClient(clientDto);
        Optional<Client> client= clientRepository.findById(clientModel.getId());
        return client.map(value -> ClientMapper.clientToClientDto(clientRepository.save(value))).orElse(null);
    }

    @Override
    public ClientDto findClientByEmail(String email) {
        Optional<Client> client = clientRepository.findClientByEmail(email);
        if (client.isPresent()){
            Client clientModel = client.get();

            return ClientMapper.clientToClientDto(clientModel);
        }
        return null;
    }

    @Override
    public List<ClientDto> findAllClients() {
        return null;
    }

    @Override
    public ClientDto findClientById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
