package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.business.exception.ApiRequestException;
import dev.juancas.shippingproject.model.dto.MessageDto;
import dev.juancas.shippingproject.model.dto.NewOrderDto;
import dev.juancas.shippingproject.model.entities.Driver;
import dev.juancas.shippingproject.model.entities.Order;
import dev.juancas.shippingproject.model.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final DriverService driverService;

    @Override
    public ResponseEntity<MessageDto> makeOrder(NewOrderDto dto) {
        Order order = new Order(dto);
        try{
            Optional<Driver> driver = driverService.findDriver();
            if (driver.isEmpty())
                return new ResponseEntity<>(new MessageDto("No se encontró un conductor"), HttpStatus.NOT_FOUND);
            order.setDriver(driver.get());
            orderRepository.save(order);
            return new ResponseEntity<>(new MessageDto("Se realizó la orden de manera exitosa!"), HttpStatus.CREATED);
        }catch (ApiRequestException e){
            throw new ApiRequestException("Hubo un error al recuperar los vehiculos");
        }
    }
}
