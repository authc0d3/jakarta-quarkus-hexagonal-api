package dev.programadorweb.testapi.products.domain.ports.in;

import dev.programadorweb.testapi.products.domain.models.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
