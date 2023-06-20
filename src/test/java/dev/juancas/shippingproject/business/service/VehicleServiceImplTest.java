package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.model.dto.SaveVehicleDto;
import dev.juancas.shippingproject.model.entities.Vehicle;
import dev.juancas.shippingproject.model.repositories.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    private Vehicle vehicle;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        vehicle = new Vehicle();
        vehicle.setPlaca("DDJ809");
        vehicle.setModelo("2020");
    }

    @Test
    void getVehicles() {
        when(vehicleRepository.findAll()).thenReturn(Arrays.asList(vehicle));
        assertNotNull(vehicleService.getVehicles());
    }

    @Test
    void newVehicle() {
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);
        assertNotNull(vehicleService.newVehicle(new SaveVehicleDto("2020","DDJ809")));
    }
}