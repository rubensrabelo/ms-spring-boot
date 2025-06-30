package io.github.rubensrabelo.client.application;

import io.github.rubensrabelo.client.application.dto.ClientCreateDTO;
import io.github.rubensrabelo.client.application.dto.ClientResponseDTO;
import io.github.rubensrabelo.client.application.exceptions.ClientNotFoundException;
import io.github.rubensrabelo.client.domain.Client;
import io.github.rubensrabelo.client.infra.repositoy.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final ModelMapper modelMapper;

    public ClientService(ClientRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public ClientResponseDTO findClientByCpf(String cpf) {
        Client entity = repository.findByCpf(cpf)
                .orElseThrow(() -> new ClientNotFoundException("Client with cpf=" + cpf + " not found."));
        return modelMapper.map(entity, ClientResponseDTO.class);
    }

    public ClientResponseDTO create(ClientCreateDTO dto) {
        Client entity = modelMapper.map(dto, Client.class);
        entity = repository.save(entity);
        return modelMapper.map(entity, ClientResponseDTO.class);
    }
}
