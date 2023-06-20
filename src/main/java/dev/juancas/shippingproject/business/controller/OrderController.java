package dev.juancas.shippingproject.business.controller;

import dev.juancas.shippingproject.business.service.OrderService;
import dev.juancas.shippingproject.model.dto.MessageDto;
import dev.juancas.shippingproject.model.dto.NewOrderDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/make")
    public ResponseEntity<MessageDto> makeOrder(@RequestBody NewOrderDto dto){
        return orderService.makeOrder(dto);
    }

}
