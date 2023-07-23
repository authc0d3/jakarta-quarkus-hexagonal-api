package dev.programadorweb.testapi.products.application.usecases;

import dev.programadorweb.testapi.products.domain.models.Product;
import dev.programadorweb.testapi.products.domain.ports.in.UpdateProductUseCase;
import dev.programadorweb.testapi.products.domain.ports.out.ProductRepositoryPort;

import java.util.Optional;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Product> updateProduct(Long productId, Product product) {
        return productRepositoryPort.update(productId, product);
    }
}
