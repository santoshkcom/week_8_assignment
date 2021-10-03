package com.greatlearning.security.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.security.entity.ItemDetails;
import com.greatlearning.security.entity.ItemSale;

public interface RestaurantService {

    List<ItemDetails> getAllItem();

    Optional<ItemDetails> getItemById(int id);

    List<ItemDetails> getItemByIds(List<Integer> ids);

    String placeOrderByIds(List<Integer> ids);

    List<ItemSale> getTotalSale();


}