package com.manage.products.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="price")
    private long price;

    @Column(name="brand")
    private String brand;

    @Column(name="onSale")
    private boolean onSale;
}
