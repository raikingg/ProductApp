package com.data.ProductApp.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Timestamp;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String productName;

    private Double productPrice;

    private String description;

    @CreatedDate
    private Date dateOfManufacture;

}
