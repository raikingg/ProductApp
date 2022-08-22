package com.data.ProductApp.controller;

import com.data.ProductApp.model.Product;
import com.data.ProductApp.model.UserModel;
import com.data.ProductApp.model.Wallet;
import com.data.ProductApp.repository.ProductRepo;
import com.data.ProductApp.repository.UserRepository;
import com.data.ProductApp.service.ProductService;
import com.data.ProductApp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
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
    @PutMapping("/product/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, Map<String, String> mapOfProduct){
        Optional<Product> product = productService.findProductById(productId);
        String newName = mapOfProduct.get("productName");
        double newPrice = 0.0;
        if(!(product.get().getProductPrice().toString().isEmpty())) {
           newPrice = Double.parseDouble(mapOfProduct.get("productPrice"));
        }
        String newDescription = mapOfProduct.get("description");
        if(newName != null){
            product.get().setProductName(newName);
        }
        if(newPrice != product.get().getProductPrice()){
            product.get().setProductPrice(newPrice);
        }
        if(newDescription != null){
            product.get().setDescription(newDescription);
        }
        Product response = productService.updateProduct(product.get());
        if(response!=null){
            return  new ResponseEntity(response,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity(response,HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> listOfAllProducts = productService.findAll();
        return  new ResponseEntity<>(listOfAllProducts,HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Optional> findProductById(@PathVariable String productId){
        Optional product =  productService.findProductById(productId);
        return new ResponseEntity<Optional>(product, HttpStatus.OK);
    }

    @PutMapping("/wallet/{username}")
    public ResponseEntity<UserModel> addMoney(@PathVariable String username, @RequestBody Wallet wallet){
        Double money = wallet.getMoney();
        UserModel user = productService.findUserByUserName(username);
//        wallet.setWalletId(user.getId());
        if(!(user ==null)){
            if((user.getWallet().getMoney())>0 && (user.getWallet().getMoney()!=null)){
                money = money + user.getWallet().getMoney();
            }
        }
        wallet.setMoney(money);
        user.setWallet(wallet);
        return  new ResponseEntity<>(productService.saveUser(user), HttpStatus.OK);
    }
}
