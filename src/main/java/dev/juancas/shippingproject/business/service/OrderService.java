package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.model.dto.MessageDto;
import dev.juancas.shippingproject.model.dto.NewOrderDto;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<MessageDto> makeOrder(NewOrderDto dto);
}
