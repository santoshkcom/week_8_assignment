package com.greatlearning.security.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.greatlearning.security.entity.ItemDetails;
import com.greatlearning.security.entity.ItemSale;
import com.greatlearning.security.repository.ItemDetailsRepository;
import com.greatlearning.security.repository.ItemSaleRepository;
import com.greatlearning.security.service.RestaurantService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    ItemDetailsRepository itemDetailsRepository;
    @Autowired
    ItemSaleRepository itemSaleRepository;

    @Override
    public List<ItemDetails> getAllItem() {
        return itemDetailsRepository.findAll();
    }

    @Override
    public Optional<ItemDetails> getItemById(int id) {
        return itemDetailsRepository.findById(id);
    }

    @Override
    public List<ItemDetails> getItemByIds(List<Integer> ids) {
        return itemDetailsRepository.findAllById(ids);
    }

    @Override
    public String placeOrderByIds(List<Integer> ids) {
        var items = itemDetailsRepository.findAllById(ids);

		int sum = items.stream().mapToInt(o->o.getPrice()).sum();

        var sales = new ArrayList<ItemSale>();

        for (ItemDetails itemDetails : items) {
            ItemSale itemSale = new ItemSale();
            itemSale.setItemId(itemDetails.getId());
            itemSale.setQuantity(1);
            itemSale.setSaleDate(LocalDate.now());
            sales.add(itemSale);
        }

        itemSaleRepository.saveAll(sales);
        itemSaleRepository.flush();

        return "Order placed! Total amount: "+ sum;


    }

    @Override
    public List<ItemSale> getTotalSale() {
        return itemSaleRepository.findAll();
    }



}
