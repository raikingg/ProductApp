package com.data.ProductApp.service;


import com.data.ProductApp.model.Product;
import com.data.ProductApp.model.UserModel;
import com.data.ProductApp.util.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    public Response saveProduct(Product product);

    public List<Product> findAll();

    UserModel findUserByUserName(String username);

    UserModel addMoney(UserModel userModel, Double money);

    UserModel saveUser(UserModel userModel);

    Optional<Product> findProductById(String productId);

    Product updateProduct(Product product);
}
