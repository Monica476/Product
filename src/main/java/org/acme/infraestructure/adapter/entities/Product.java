package org.acme.infraestructure.adapter.entities;


import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@MongoEntity(collection = "product")
public class Product {
    @BsonId
    @BsonProperty("_id")
    private ObjectId id;
    @BsonProperty("code")
    private String code;
    @BsonProperty("description")
    private String description;
    @BsonProperty("name")
    private String name;
}