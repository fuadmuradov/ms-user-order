package org.example.msorder.service.abstraction;

import org.example.msorder.model.request.OrderRequest;
import org.example.msorder.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    void addOrder(OrderRequest orderRequest);
    void removeOrder(Long id);
    OrderResponse getOrder(Long id);
    List<OrderResponse> getOrders();


}
