package dev.programadorweb.testapi.products.domain.ports.in;

import dev.programadorweb.testapi.products.domain.models.Product;

import java.util.Optional;

public interface DeleteProductUseCase {
    Optional<Product> deleteProduct(Long productId);
}
