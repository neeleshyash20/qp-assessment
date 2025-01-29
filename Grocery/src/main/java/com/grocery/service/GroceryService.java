package com.grocery.service;

import com.grocery.Entity.GroceryItems;
import com.grocery.repo.GroceryItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {
    @Autowired
    private GroceryItemRepo groceryItemRepo;
    public GroceryItems addItems(GroceryItems item) {
        return groceryItemRepo.save(item);
    }


    public List<GroceryItems> getItem() {
        return groceryItemRepo.findAll();
    }

    public void deleteItem(long id) {
        groceryItemRepo.deleteById(id);
    }

    public void updateItem(GroceryItems items) {
        groceryItemRepo.save(items);
    }

    public GroceryItems getItem (Long id){
        GroceryItems groceryItems =  groceryItemRepo.findById(id).orElseThrow(()->new RuntimeException("Item not found"));
        return groceryItems;
    }

    public List<GroceryItems> getItems(List<Long> id) {
        return groceryItemRepo.findAllById(id);
    }
}
