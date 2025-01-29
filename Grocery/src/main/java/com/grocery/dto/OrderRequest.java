package com.grocery.dto;

import java.util.List;

public class OrderRequest {

    private String userId;

    private List<OrderRequestItems> orderRequestItemsList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderRequestItems> getOrderRequestItemsList() {
        return orderRequestItemsList;
    }

    public void setOrderRequestItemsList(List<OrderRequestItems> orderRequestItemsList) {
        this.orderRequestItemsList = orderRequestItemsList;
    }
}
