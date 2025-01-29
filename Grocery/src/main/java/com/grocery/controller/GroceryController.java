package com.grocery.controller;

import com.grocery.Entity.GroceryItems;
import com.grocery.repo.GroceryItemRepo;
//import com.grocery.security.JwtUtill;
import com.grocery.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @Autowired
    private GroceryItemRepo groceryItemRepo;

//    @Autowired
//    private JwtUtill jwtUtil;

    @PostMapping("/add/item")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GroceryItems> addItem (@RequestBody GroceryItems item){
        return (ResponseEntity.ok(groceryService.addItems(item)));
    }

    @GetMapping("/get/item")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<GroceryItems>> getItem (){
        return ResponseEntity.ok(groceryService.getItem());
    }

    @DeleteMapping("/delete/item/{id}")
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteItem (@PathVariable Long id){
            //groceryItemRepo.deleteById(id);
            groceryService.deleteItem(id);
            return ResponseEntity.ok().build();
    }

    @PutMapping("/update/items")
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GroceryItems> updateItems (@RequestBody GroceryItems item){
        //GroceryItems items = new GroceryItems();
        item.setName(item.getName());
        item.setPrice(item.getPrice());
        item.setCategory(item.getCategory());
        groceryService.updateItem(item);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/item/{id}/inventory")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GroceryItems> updateInventory(@PathVariable Long id, @RequestParam Integer inventory){

        GroceryItems item = groceryService.getItem(id);
        item.setInventory(inventory);
        groceryService.updateItem(item);
        return ResponseEntity.ok().build();

    }


//    @PostMapping("/add")
//    public ResponseEntity<String> addGroceryItem(@RequestHeader("Authorization") String token) {
//        if (jwtUtil.validateToken(token)) {
//            String role = jwtUtil.extractRole(token);  // Get role from token
//
//            if ("ADMIN".equals(role)) {
//                // Admin-specific logic
//                return ResponseEntity.ok("Item added");
//            } else {
//                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized");
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid token");
//        }
//    }
}
