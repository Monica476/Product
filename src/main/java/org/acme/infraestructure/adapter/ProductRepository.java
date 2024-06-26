package org.acme.infraestructure.adapter;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.infraestructure.adapter.entities.Product;
import org.bson.types.ObjectId;

@ApplicationScoped
public class ProductRepository implements PanacheMongoRepositoryBase<Product, ObjectId> {


}
