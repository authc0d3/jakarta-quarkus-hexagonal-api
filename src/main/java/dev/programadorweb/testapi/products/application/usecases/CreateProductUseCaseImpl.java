package dev.programadorweb.testapi.products.application.usecases;

import dev.programadorweb.testapi.products.domain.models.Product;
import dev.programadorweb.testapi.products.domain.ports.in.CreateProductUseCase;
import dev.programadorweb.testapi.products.domain.ports.out.ProductRepositoryPort;

public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPort.create(product);
    }
}
