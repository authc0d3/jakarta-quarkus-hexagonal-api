package dev.programadorweb.testapi.products.infrastructure.controllers;

import dev.programadorweb.testapi.products.domain.models.Product;
import dev.programadorweb.testapi.products.domain.ports.out.ProductRepositoryPort;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductController {

    private final ProductRepositoryPort productRepositoryPort;

    @Inject
    public ProductController(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @GET
    public Response getAll() {
        final List<Product> products = productRepositoryPort.getAll();
        return Response.status(200).entity(products).build();
    }

    @GET
    @Path("/{productId}")
    public Response getById(@PathParam("productId") Long productId) {
        final Optional<Product> product = productRepositoryPort.getById(productId);
        if (product.isEmpty()) return Response.status(404).build();
        return Response.status(200).entity(product).build();
    }

    @POST
    public Response create(Product product) {
        final Product newProduct = productRepositoryPort.create(product);
        return Response.status(200).entity(newProduct).build();
    }

    @PUT
    @Path("/{productId}")
    public Response update(@PathParam("productId") Long productId, Product product) {
        final Optional<Product> updatedProduct = productRepositoryPort.update(productId, product);
        if (updatedProduct.isEmpty()) return Response.status(404).build();
        return Response.status(200).entity(updatedProduct).build();
    }

    @DELETE
    @Path("/{productId}")
    public Response delete(@PathParam("productId") Long productId) {
        final Optional<Product> deletedProduct = productRepositoryPort.delete(productId);
        if (deletedProduct.isEmpty()) return Response.status(404).build();
        return Response.status(200).entity(deletedProduct).build();
    }
}
