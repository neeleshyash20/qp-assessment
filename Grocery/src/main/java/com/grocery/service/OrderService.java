package com.grocery.service;

import com.grocery.Entity.GroceryItems;
import com.grocery.Entity.OrderItems;
import com.grocery.Entity.Orders;
import com.grocery.Entity.Users;
import com.grocery.dto.OrderRequestItems;
import com.grocery.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserServices userService;
    @Autowired
    private GroceryService groceryService;

    public Orders bookMultipleGroceryItems(String userId, List<OrderRequestItems> items) throws Exception {
        try {
            Users user = userService.findUser(userId);
            BigDecimal totalAmt = BigDecimal.ZERO;
            if ((user != null) && (user.getRole().equals("CUSTOMER"))) {
                Orders orders = new Orders();
                orders.setUserId(user.getId());
                orders.setStatus("InProcess");


                //List<OrderItems> orderItems = new ArrayList<>();
                for(OrderRequestItems item : items) {
                   GroceryItems groceryItems = groceryService.getItem(item.getGroceryItemId());

                   if((groceryItems != null) && (groceryItems.getInventory() > item.getQuantity())){
                      // totalAmt = totalAmt + (item.getQuantity() * groceryItems.getPrice());
                       BigDecimal price = groceryItems.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
                       totalAmt = totalAmt.add(price);
                       OrderItems orderItems1 = new OrderItems();
                       orderItems1.setGroceryItem(groceryItems);
                       orderItems1.setQuantity(item.getQuantity());
                       orderItems1.setPricePerUnit(groceryItems.getPrice());
                       //orderItems.add(orderItems1);
                       orders.addOrderItem(orderItems1);
                       groceryItems.setInventory(groceryItems.getInventory() - item.getQuantity());
                   }
                   else {
                       throw new Exception("Insufficient quantity");
                   }
                }



                //orders.setOrderItems(orderItems);

                orders.setTotalAmount(totalAmt);

                System.out.println(orders);
                orderRepo.save(orders);
                return orders;
            }
            else {
                throw new Exception("User do not have proper role");
            }
        }catch (Exception e){
            throw e;
        }
    }
}
