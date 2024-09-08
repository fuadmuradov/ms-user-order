package org.example.msorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.msorder.model.request.OrderRequest;
import org.example.msorder.model.response.OrderResponse;
import org.example.msorder.service.abstraction.OrderService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("v1/orders")
@RequiredArgsConstructor
public class OrderController {
    protected final OrderService orderService;
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderRequest orderRequest) {
        log.warn("Creating order: {}", orderRequest);
        orderService.addOrder(orderRequest);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders() {
        log.warn("Get orders: {}", orderService.getOrders());
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
