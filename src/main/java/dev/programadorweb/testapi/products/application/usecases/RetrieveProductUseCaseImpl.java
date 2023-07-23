package dev.programadorweb.testapi.products.application.usecases;

import dev.programadorweb.testapi.products.domain.models.Product;
import dev.programadorweb.testapi.products.domain.ports.in.RetrieveProductUseCase;
import dev.programadorweb.testapi.products.domain.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public RetrieveProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return productRepositoryPort.getById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryPort.getAll();
    }
}
