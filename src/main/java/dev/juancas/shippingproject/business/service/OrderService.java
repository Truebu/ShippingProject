package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.model.dto.MessageDto;
import dev.juancas.shippingproject.model.dto.NewOrderDto;
import dev.juancas.shippingproject.model.dto.OrdersDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    ResponseEntity<MessageDto> makeOrder(NewOrderDto dto);

    ResponseEntity<List<OrdersDto>> showOrders();
}
