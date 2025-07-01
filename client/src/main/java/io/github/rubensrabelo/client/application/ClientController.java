package io.github.rubensrabelo.client.application;

import io.github.rubensrabelo.client.application.dto.ClientCreateDTO;
import io.github.rubensrabelo.client.application.dto.ClientResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clients")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<ClientResponseDTO> findByCpf(@RequestParam("cpf") String cpf) {
        log.info("GET /clients?cpf={} - Searching for customer data with cpf: ", cpf);
        log.info("-- " + cpf);

        ClientResponseDTO dto = service.findClientByCpf(cpf);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody ClientCreateDTO dto) {
        log.info("POST /clients - Receiving request to save client: {}", dto);

        ClientResponseDTO dtoResponse = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(dtoResponse.getCpf())
                .toUri();

        log.info("Client saved successfully. Location URI: {}", uri);

        return ResponseEntity.created(uri).body(dtoResponse);
    }
}
