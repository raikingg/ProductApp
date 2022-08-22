package com.data.ProductApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "wallet")
public class Wallet {
//
//    @OneToOne
//    private String walletId;

    private Double money;
}
