package org.acme.infraestructure.rest.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.application.usecasses.ProductService;
import org.acme.infraestructure.adapter.entities.Product;
import org.bson.types.ObjectId;
import org.jboss.logging.annotations.Param;

import java.util.List;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductApi {
    @Inject
    ProductService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Product> list() {
        return service.list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void create(Product producto) {
        service.create(producto);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Product update(@Param Product producto) {
        service.update(producto);
        return producto;
    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@Param ObjectId id) {
        service.delete(id);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product obtenerId(@PathParam("id") ObjectId id) {
       return  service.obtenerId(id);
    }


}
