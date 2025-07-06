package io.github.rubensrabelo.product.application;

import io.github.rubensrabelo.product.application.dto.ProductCreateDTO;
import io.github.rubensrabelo.product.application.dto.ProductResponseDTO;
import io.github.rubensrabelo.product.application.dto.PurchaseMessageDTO;
import io.github.rubensrabelo.product.application.exceptions.InvalidQuantityValueException;
import io.github.rubensrabelo.product.application.exceptions.ProductIsNotInStockException;
import io.github.rubensrabelo.product.application.exceptions.ProductNotFoundException;
import io.github.rubensrabelo.product.domain.Product;
import io.github.rubensrabelo.product.infra.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Product findById(Long id){
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id=" + id + " not found."));
        return product;
    }

    public ProductResponseDTO create(ProductCreateDTO dtoCreate){
        Product entity = modelMapper.map(dtoCreate, Product.class);
        entity = repository.save(entity);
        return modelMapper.map(entity, ProductResponseDTO.class);
    }

    public PurchaseMessageDTO updateQuantity(Long id, int quantity){
        if(quantity < 1)
            throw new InvalidQuantityValueException("Quantity value cannot be less than 1.");

        Product entity = findById(id);

        if (entity.getQuantity() == 0)
            throw new ProductIsNotInStockException("Product is not available in stock.");

        if(quantity > entity.getQuantity())
            throw new InvalidQuantityValueException("Quantity value cannot be greater than current quantity.");

        entity.setQuantity(entity.getQuantity() - quantity);
        entity = repository.save(entity);

        String message = "Purchase completed successfully.";
        double value = entity.getUnitValue() * quantity;

        PurchaseMessageDTO messageDTO = new PurchaseMessageDTO(message, quantity, value);

        return messageDTO;
    }
}
