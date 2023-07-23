package dev.programadorweb.testapi.products.application.usecases;

import dev.programadorweb.testapi.products.domain.models.Product;
import dev.programadorweb.testapi.products.domain.ports.in.DeleteProductUseCase;
import dev.programadorweb.testapi.products.domain.ports.out.ProductRepositoryPort;

import java.util.Optional;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Product> deleteProduct(Long productId) {
        return productRepositoryPort.delete(productId);
    }
}
