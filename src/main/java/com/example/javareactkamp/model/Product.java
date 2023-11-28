package com.example.javareactkamp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @NotEmpty
    @Column(name = "category_id")
    private int category;
    @NotNull
    @NotEmpty

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
