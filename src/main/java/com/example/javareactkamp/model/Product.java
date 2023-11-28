package com.example.javareactkamp.model;

import jakarta.persistence.*;
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
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "quantity_per_unit", nullable = false)
    private String quantityPerUnit;
    @Column(name = "unit_price", nullable = false)
    private double unitPrice;
    @Column(name = "unit_in_stock", nullable = false)
    private int unitInStock;
    @Column(name = "units_on_order", nullable = false)
    private int unitsOnOrder;

    @Column(name = "reorder_level", nullable = false)
    private int reorderLevel;
    @Column(name = "discontiuned", nullable = false)
    private int discontiuned;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
