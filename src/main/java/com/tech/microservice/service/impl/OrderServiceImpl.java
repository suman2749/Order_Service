package com.tech.microservice.service.impl;

import com.tech.microservice.client.InventoryClient;
import com.tech.microservice.dto.OrderRequest;
import com.tech.microservice.dto.OrderResponse;
import com.tech.microservice.model.Order;
import com.tech.microservice.repository.OrderRepository;
import com.tech.microservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final InventoryClient inventoryClient;

    @Override
    public OrderResponse PlaceOrder(OrderRequest orderRequest) {
        var productIsInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (productIsInStock) {
            Order order = new Order();
            order.setOrderNumber(orderRequest.orderNumber()); // Use the passed-in value
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            Order savedOrder = orderRepository.save(order);

            return new OrderResponse(
                    savedOrder.getOrderId(),
                    savedOrder.getOrderNumber(),
                    savedOrder.getSkuCode(),
                    savedOrder.getPrice(),
                    savedOrder.getQuantity()
            );
        }else {
            throw new RuntimeException("Product is not in stock : " + orderRequest.skuCode());
        }
    }
}
