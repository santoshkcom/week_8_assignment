package com.greatlearning.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetails {
    @Id
    private Integer id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "PRICE")
    private int price;

}
