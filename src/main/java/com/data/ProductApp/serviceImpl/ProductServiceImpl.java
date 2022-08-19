package com.data.ProductApp.serviceImpl;


import com.data.ProductApp.model.Product;
import com.data.ProductApp.repository.ProductRepo;
import com.data.ProductApp.service.ProductService;
import com.data.ProductApp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    public Response saveProduct(Product product) {
        List<Product> listOfAllProducts = productRepo.findAll();
        Set<String> setOfProductNames = new HashSet<>();
        for(Product productValue : listOfAllProducts){
            if(productValue.getProductName().equalsIgnoreCase(product.getProductName())){
                return new Response(HttpStatus.CONFLICT,"Already Exists");
            }
        }
       productRepo.save(product);
        return new Response(HttpStatus.CREATED,"Created",product);

    }

    @Override
    public List<Product> findAll() {
       return productRepo.findAll();
    }

}
