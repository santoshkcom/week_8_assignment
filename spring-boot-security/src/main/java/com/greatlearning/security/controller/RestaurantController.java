package com.greatlearning.security.controller;

import java.util.List;
import java.util.Optional;

import com.greatlearning.security.entity.ItemDetails;
import com.greatlearning.security.entity.ItemSale;
import com.greatlearning.security.service.RestaurantService;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService retailStoreService;

    @GetMapping("/getItemById")
    public Optional<ItemDetails> getItemById(int id) {
        return retailStoreService.getItemById(id);
    }

    @GetMapping("/getAllItem")
    public List<ItemDetails> getAllItem() {
        return retailStoreService.getAllItem();
    }


    @PostMapping("/getItemByIds")
    public List<ItemDetails> getItemByIds(@RequestBody List<Integer> ids) {
        return retailStoreService.getItemByIds(ids);
    }

    @PostMapping("/placeOrderByIds")
    public String placeOrderByIds(@RequestBody List<Integer> ids) {
        return retailStoreService.placeOrderByIds(ids);
    }

    @GetMapping("/getTotalSale")
    public List<ItemSale> getTotalSale() {
        return retailStoreService.getTotalSale();
    }


}
