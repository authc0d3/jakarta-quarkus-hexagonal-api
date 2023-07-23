package dev.programadorweb.testapi.products.domain.ports.out;
import dev.programadorweb.testapi.products.domain.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    public List<Product> getAll();

    public Optional<Product> getById(Long productId);

    public Product create(Product product);

    public Optional<Product> update(Long productId, Product product);

    public Optional<Product> delete(Long productId);
}
