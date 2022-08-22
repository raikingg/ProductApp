package com.data.ProductApp.serviceImpl;


import com.data.ProductApp.model.Product;
import com.data.ProductApp.model.UserModel;
import com.data.ProductApp.model.Wallet;
import com.data.ProductApp.repository.ProductRepo;
import com.data.ProductApp.repository.UserRepository;
import com.data.ProductApp.service.ProductService;
import com.data.ProductApp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepository userRepo;
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

    @Override
    public UserModel findUserByUserName(String username){
        return userRepo.findByUsername(username);
    }

    @Override
    public UserModel addMoney(UserModel userModel, Double money){
        UserModel user = new UserModel();
        Wallet wallet = new Wallet();
        wallet.setMoney(money);
        user.setWallet(wallet);
        userRepo.save(user);

        return user;
    }

    @Override
    public UserModel saveUser(UserModel userModel){
        return userRepo.save(userModel);
    }

    @Override
    public Optional<Product> findProductById(String productId) {
        return productRepo.findById(productId);
    }

    @Override
    public Product updateProduct(Product product) {
        return  productRepo.save(product);
    }
}
