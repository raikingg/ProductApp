package com.data.ProductApp.service;


import com.data.ProductApp.model.ProductUserDetails;
import com.data.ProductApp.model.UserModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import java.util.List;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
 
    @Autowired
    private MongoClient mongoClient;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
        MongoDatabase database = mongoClient.getDatabase("productDB");
        MongoCollection<Document> collection = database.getCollection("users");
 
        Document document = collection.find(Filters.eq("name",username)).first();
        if(document!=null) {
 
            String name = document.getString("name");
            String password = document.getString("password");
            List<String> authorities = (List<String>) document.get("authorities");
 
            ProductUserDetails productUserDetails = new ProductUserDetails(name,password,authorities.toArray(new String[authorities.size()]));
 
            return productUserDetails;
        }
 
        return null;
    }
 
}