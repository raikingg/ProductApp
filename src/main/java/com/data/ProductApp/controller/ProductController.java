package com.data.ProductApp.controller;

import com.data.ProductApp.model.Product;
import com.data.ProductApp.service.ProductService;
import com.data.ProductApp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datapoem")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/echo")
    public String echo(){
        return "Hello there";
    }

    @PostMapping("/product")
    public ResponseEntity addProduct(@RequestBody Product product){
        Response response = productService.saveProduct(product);
        if(response.getMessage().equalsIgnoreCase("created")){
            return  new ResponseEntity(response,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity(response,HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/product")
    public Response findAll(){
        List<Product> listOfAllProducts = productService.findAll();
        return  new Response(HttpStatus.OK,"Fetched successfully",listOfAllProducts);
    }
}
