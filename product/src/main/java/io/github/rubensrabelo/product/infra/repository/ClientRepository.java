package io.github.rubensrabelo.product.infra.repository;

import io.github.rubensrabelo.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Product, Long> {
}
