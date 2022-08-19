package com.data.ProductApp.service;


import com.data.ProductApp.model.Product;
import com.data.ProductApp.util.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Response saveProduct(Product product);

    public List<Product> findAll();
}
