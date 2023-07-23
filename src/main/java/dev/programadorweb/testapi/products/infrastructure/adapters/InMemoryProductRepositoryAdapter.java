package dev.programadorweb.testapi.products.infrastructure.adapters;

import dev.programadorweb.testapi.products.domain.models.Product;
import dev.programadorweb.testapi.products.domain.ports.out.ProductRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class InMemoryProductRepositoryAdapter implements ProductRepositoryPort {

    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Optional<Product> getById(Long productId) {
        return products.stream().filter((p) -> p.getId()
                .equals(productId))
                .findFirst();
    }

    @Override
    public Product create(Product product) {
        Long maxId = products
                .stream()
                .mapToLong(p -> p.getId())
                .max()
                .orElse(0);
        product.setId(maxId + 1);
        products.add(product);
        return  product;
    }

    @Override
    public Optional<Product> update(Long productId, Product product) {
        products = products.stream()
                .map(p -> p.getId().equals(productId) ? product : p)
                .collect(Collectors.toList());
        return products.stream()
                .filter((p) -> p.getId().equals(productId))
                .findFirst();
    }

    @Override
    public Optional<Product> delete(Long productId) {
        final Optional<Product> product =
                products.stream().filter((p) -> p.getId().equals(productId)).findFirst();
        if (product.isPresent()) {
            products = products.stream()
                    .filter(p -> !p.getId().equals(productId))
                    .collect(Collectors.toList());
        }
        return product;
    }
}
