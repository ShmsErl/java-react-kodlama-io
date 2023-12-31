package com.example.javareactkamp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;


    @Column(name = "product_name")
    private String name;

    @NotNull
    @NotEmpty
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @NotNull
    @NotEmpty
    @Min(value = 0)
    @Column(name = "unit_price")
    private double unitPrice;

    @Min(value = 0)
    @Column(name = "units_in_stock")
    private int unitInStock;

    @Column(name = "units_on_order")
    private int unitsOnOrder;


    @Column(name = "reorder_level")
    private int reorderLevel;

    @Column(name = "discontinued")
    private int discontinued;



}
