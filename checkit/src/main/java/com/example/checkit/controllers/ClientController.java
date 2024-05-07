package com.example.checkit.controllers;

import com.example.checkit.dto.ClientDto;
import com.example.checkit.service.serviceImplementation.ClientServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/clients")
public class ClientController {

    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public ClientDto createClient(@RequestBody ClientDto clientDto){
          return clientService.create(clientDto);
    }
}
