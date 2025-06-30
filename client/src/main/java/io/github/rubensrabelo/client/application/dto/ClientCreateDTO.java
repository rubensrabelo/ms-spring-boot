package io.github.rubensrabelo.client.application.dto;

public record ClientCreateDTO(
        String name,
        String cpf,
        String email
) {}
