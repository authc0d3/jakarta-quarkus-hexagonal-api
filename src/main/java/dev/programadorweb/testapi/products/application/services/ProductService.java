package dev.programadorweb.testapi.products.application.services;

import dev.programadorweb.testapi.products.domain.models.Product;
import dev.programadorweb.testapi.products.domain.ports.in.CreateProductUseCase;
import dev.programadorweb.testapi.products.domain.ports.in.DeleteProductUseCase;
import dev.programadorweb.testapi.products.domain.ports.in.RetrieveProductUseCase;
import dev.programadorweb.testapi.products.domain.ports.in.UpdateProductUseCase;

import java.util.List;
import java.util.Optional;

public class ProductService implements RetrieveProductUseCase, CreateProductUseCase, UpdateProductUseCase, DeleteProductUseCase {
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductService(RetrieveProductUseCase retrieveProductUseCase, CreateProductUseCase createProductUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.createProductUseCase = createProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @Override
    public Product createProduct(Product product) {
        return createProductUseCase.createProduct(product);
    }

    @Override
    public Optional<Product> deleteProduct(Long productId) {
        return deleteProductUseCase.deleteProduct(productId);
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return retrieveProductUseCase.getProduct(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return retrieveProductUseCase.getAllProducts();
    }

    @Override
    public Optional<Product> updateProduct(Long productId, Product product) {
        return updateProductUseCase.updateProduct(productId, product);
    }
}
