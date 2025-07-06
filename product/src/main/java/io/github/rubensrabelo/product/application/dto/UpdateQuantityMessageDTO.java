package io.github.rubensrabelo.product.application.dto;

public record UpdateQuantityMessageDTO(
        String message,
        int quantity,
        double value
) {
}
