package dev.programadorweb.testapi.products.domain.ports.in;

import dev.programadorweb.testapi.products.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface RetrieveProductUseCase {
    Optional<Product> getProduct(Long productId);
    List<Product> getAllProducts();
}
