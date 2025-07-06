package io.github.rubensrabelo.product.application;

import io.github.rubensrabelo.product.application.dto.ProductCreateDTO;
import io.github.rubensrabelo.product.application.dto.ProductResponseDTO;
import io.github.rubensrabelo.product.application.dto.UpdateQuantityMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductController.class);

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductCreateDTO dtoCreate){
        return ResponseEntity.ok().body(service.create(dtoCreate));
    }

    @PutMapping(params = {"id", "quantity"})
    public ResponseEntity<UpdateQuantityMessageDTO> updateQuantity(
            @RequestParam("id") Long id,
            @RequestParam("quantity") int quantity){
        return ResponseEntity.ok().body(service.updateQuantity(id, quantity));
    }
}
