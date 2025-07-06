package io.github.rubensrabelo.product.application.dto;

public record PurchaseMessageDTO(
        String message,
        int quantity,
        double value
) {
}
