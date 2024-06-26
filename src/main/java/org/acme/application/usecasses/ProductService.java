package org.acme.application.usecasses;

import jakarta.ws.rs.PathParam;
import org.acme.infraestructure.adapter.entities.Product;
import org.bson.types.ObjectId;
import org.jboss.logging.annotations.Param;

import java.util.List;

public interface ProductService {
    List<Product> list();
    void create(Product producto) ;

    void update(@Param Product producto) ;

    void delete(@Param ObjectId id) ;
    Product obtenerId(@PathParam("id") ObjectId id) ;

}
