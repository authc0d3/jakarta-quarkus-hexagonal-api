package dev.programadorweb.testapi.products.domain.ports.in;

import dev.programadorweb.testapi.products.domain.models.Product;

import java.util.Optional;

public interface UpdateProductUseCase {
    Optional<Product> updateProduct(Long productId, Product product);
}
