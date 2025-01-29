package com.grocery.controller;

import com.grocery.Entity.GroceryItems;
import com.grocery.Entity.OrderItems;
import com.grocery.Entity.Orders;
import com.grocery.Entity.Users;
import com.grocery.dto.OrderRequest;
import com.grocery.dto.OrderRequestItems;
import com.grocery.service.GroceryService;
import com.grocery.service.OrderService;
import com.grocery.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")

public class OrdersController {

    @Autowired
    private GroceryService groceryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserServices userService;

    @GetMapping("/list/grocery-items")
    //@PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<List<GroceryItems>> getList() {
        List<GroceryItems> item = groceryService.getItem();
        List<GroceryItems> items = item.stream().filter(groceryItemList -> groceryItemList.getInventory() > 0).collect(Collectors.toList());
        return ResponseEntity.ok(items);
    }

    @PostMapping("/book-multiple-grocery")
    //@PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<Orders> book (@RequestBody OrderRequest request) throws Exception {

        String userId = request.getUserId();
        List<OrderRequestItems> items = request.getOrderRequestItemsList();
        Orders orders = orderService.bookMultipleGroceryItems(userId, items);
        return ResponseEntity.ok(orders);

    }

}
