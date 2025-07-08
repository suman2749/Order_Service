package com.tech.microservice.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponse {
    private Long orderId;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}

