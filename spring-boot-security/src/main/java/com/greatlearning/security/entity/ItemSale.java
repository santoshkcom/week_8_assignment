package com.greatlearning.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemSale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "ITEM_ID")
    private int itemId;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "SALE_DATE")
    private LocalDate saleDate;
}
