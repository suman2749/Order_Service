package com.tech.microservice.dto;

import java.math.BigDecimal;

public record OrderRequest(Long orderId, String orderNumber, String skuCode,
                           BigDecimal price, Integer quantity) {
}
