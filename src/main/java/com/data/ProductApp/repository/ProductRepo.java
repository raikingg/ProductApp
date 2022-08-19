package com.data.ProductApp.repository;



import com.data.ProductApp.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends MongoRepository<Product,String> {
    @Override
    <S extends Product> S save(S entity);

    @Override
    List<Product> findAll();
}
