package org.example.msorder.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.msorder.enums.OrderStatus;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
public class OrderRequest {
    private Long userId;

    private BigDecimal totalAmount;

    private OrderStatus status;

    private String shippingAddress;
}
