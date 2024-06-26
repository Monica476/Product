package org.acme.infraestructure.rest.graphql;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.acme.application.usecasses.ProductService;
import org.acme.infraestructure.adapter.entities.Product;
import org.acme.infraestructure.adapter.repository.IProductRepository;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;
@GraphQLApi
public class ProductResource {

    @Inject
    ProductService repository;


    @Query("allProducts")
    @Description("Es un metodo que devuelve todos los clientes")
    public Uni<List<Product>> getAllProduct(){
        return (Uni<List<Product>>) repository.list();
    }

    @Query("Product")
    @Description("Es un metodo que devuelve todos los clientes")
    public Product getProduct(@Name("customerId") ObjectId id){
        return  repository.obtenerId(id);
    }
}
