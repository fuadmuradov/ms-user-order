package org.example.msorder.mapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.msorder.entity.OrderEntity;
import org.example.msorder.model.request.OrderRequest;
import org.example.msorder.model.response.OrderResponse;

@RequiredArgsConstructor
public enum OrderMapper {
    ORDER_MAPPER;
    public OrderEntity mapToEntity(OrderRequest request) {
        return OrderEntity.builder()
                .userId(request.getUserId())
                .totalAmount(request.getTotalAmount())
                .shippingAddress(request.getShippingAddress())
                .status(request.getStatus())
                .build();
    }

    public OrderResponse mapToResponse(OrderEntity entity) {
        return OrderResponse.builder()
                .userId(entity.getUserId())
                .totalAmount(entity.getTotalAmount())
                .shippingAddress(entity.getShippingAddress())
                .status(entity.getStatus())
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .orderDate(entity.getOrderDate())
                .build();

    }
}
