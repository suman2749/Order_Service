package com.tech.microservice.service;

import com.tech.microservice.dto.OrderRequest;
import com.tech.microservice.dto.OrderResponse;

public interface OrderService {
    public OrderResponse PlaceOrder(OrderRequest orderRequest);
}
