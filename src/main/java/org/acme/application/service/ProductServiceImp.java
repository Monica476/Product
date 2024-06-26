package org.acme.application.service;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheResult;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.acme.application.usecasses.ProductService;
import org.acme.infraestructure.adapter.entities.Product;
import org.acme.infraestructure.adapter.ProductRepository;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.jboss.logging.annotations.Param;

import java.util.List;

@ApplicationScoped
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;

    @Inject
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CacheResult(cacheName = "product")
    public Product obtenerId(@PathParam("id") ObjectId id) {
        return productRepository.findById(id);
    }

    @CacheResult(cacheName = "products")
    public List<Product> list() {
        return productRepository.listAll();
    }

    public void create(Product producto) {
        productRepository.persist(producto);
    }

    public void update(Product producto) {
         productRepository.persistOrUpdate(producto);
    }

    @CacheInvalidate(cacheName = "product")
    public void delete(@Param ObjectId id) {
        productRepository.deleteById(id);
    }



    @CacheInvalidateAll(cacheName = "products")
    public void clearProductCache() {
        System.out.println("Clearing product cache...");
    }

    @CircuitBreaker(
        requestVolumeThreshold=4,
        failureRatio= 0.5
    )
    public Uni<String> callExternalService() {
        return Uni.createFrom().item("Result from external service");
        // se puede usar en servicios externos o peticiones a base de datos externas
        // mas comunmente en base de datos cloud por fallas de conectividad o fallas temporales
    }
}
