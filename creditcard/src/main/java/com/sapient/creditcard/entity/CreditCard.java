package com.sapient.creditcard.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique=true)
    private String number;
    private Integer limit;
    private Double balance=0.00;

}
//  {
//        "id": 1,
//        "name": "kdnjkgnjfkjnds",
//        "number": "324345336547565",
//        "limit": 100034000,
//        "balance": 0.0
//    },
//    {
//        "id": 4,
//        "name": "kdnjkgnjfkjnds",
//        "number": "32434533654756526",
//        "limit": 100034000,
//        "balance": 0.0
//    },
//    {
//        "id": 6,
//        "name": "kdnjkgnjfkjnds",
//        "number": "3243453365475652626",
//        "limit": 100034000,
//        "balance": 0.0
//    },
//    {
//        "id": 8,
//        "name": "kdnjkgnjfkjnds",
//        "number": "3243453365475652642",
//        "limit": 100034000,
//        "balance": 0.0
//    },
//    {
//        "id": 14,
//        "name": "kdnjkgnjfkjnds",
//        "number": "4345336547565261",
//        "limit": 100034000,
//        "balance": 0.0
//    }