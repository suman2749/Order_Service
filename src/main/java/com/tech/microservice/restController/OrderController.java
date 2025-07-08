package com.tech.microservice.restController;

import com.tech.microservice.dto.OrderRequest;
import com.tech.microservice.dto.OrderResponse;
import com.tech.microservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")

public class OrderController {
    private final OrderService orderService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/place")
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Received request to place an order");
        return orderService.PlaceOrder(orderRequest);
    }
}
