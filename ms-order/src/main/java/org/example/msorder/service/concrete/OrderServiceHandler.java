package org.example.msorder.service.concrete;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.msorder.annotation.ElapsedTimeLogger;
import org.example.msorder.annotation.Loggable;
import org.example.msorder.client.UserClient;
import org.example.msorder.entity.OrderEntity;
import org.example.msorder.exception.NotFoundException;
import org.example.msorder.model.request.OrderRequest;
import org.example.msorder.model.response.OrderResponse;
import org.example.msorder.repository.OrderRepository;
import org.example.msorder.service.abstraction.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.msorder.exception.ErrorConstants.NOTFOUND_ERROR;
import static org.example.msorder.mapper.OrderMapper.ORDER_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceHandler implements OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    @Override
    @Loggable
    @ElapsedTimeLogger
    public void addOrder(OrderRequest orderRequest) {
        log.info("Adding order: {}", orderRequest);
        var user = userClient.getUser(orderRequest.getUserId());
        log.warn("User: {}", user);
        if (user.isPresent()) {
            var order = ORDER_MAPPER.mapToEntity(orderRequest);
            order.setIsDeleted(false);
            orderRepository.save(order);
        }

    }

    @Override
    @Loggable
    @ElapsedTimeLogger
    public void removeOrder(Long id) {
        var order = getOrderEntity(id);
        order.setIsDeleted(true);
        orderRepository.save(order);
    }

    @Override
    @Loggable
    @ElapsedTimeLogger
    public OrderResponse getOrder(Long id) {
        var order = getOrderEntity(id);
        return ORDER_MAPPER.mapToResponse(order);
    }

    @Override
    @Loggable
    @ElapsedTimeLogger
    public List<OrderResponse> getOrders() {
        var orders = orderRepository.findAllByIsDeletedIsFalse();
        return orders.stream().map(ORDER_MAPPER::mapToResponse).toList();

    }

    private OrderEntity getOrderEntity(Long id) {
        return orderRepository.findByIdAndIsDeletedIsFalse(id).
                orElseThrow(() -> new NotFoundException(NOTFOUND_ERROR.getCode(),
                        NOTFOUND_ERROR.getMessage()));
    }
}
