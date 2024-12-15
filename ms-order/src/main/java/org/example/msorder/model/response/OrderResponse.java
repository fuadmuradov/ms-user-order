package org.example.msorder.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.example.msorder.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Builder
public class OrderResponse {
    private Long id;

    private Long userId;

    private LocalDateTime orderDate;

    private BigDecimal totalAmount;

    private OrderStatus status;

    private String shippingAddress;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
