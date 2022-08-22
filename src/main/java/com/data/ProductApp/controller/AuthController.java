package com.data.ProductApp.controller;

import com.data.ProductApp.model.AuthenticationRequest;
import com.data.ProductApp.model.UserModel;
import com.data.ProductApp.model.Wallet;
import com.data.ProductApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/datapoem")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public String addUser(@RequestBody AuthenticationRequest authenticationRequest){
        UserModel user = new UserModel();
        user.setUsername(authenticationRequest.getUsername());
        user.setPassword(authenticationRequest.getPassword());
        Wallet wallet = new Wallet();
        wallet.setMoney(0.0);
        user.setWallet(wallet);
        userRepository.save(user);
        return "User Added";
    }
}
