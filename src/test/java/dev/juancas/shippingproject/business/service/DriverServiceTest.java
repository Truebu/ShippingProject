package dev.juancas.shippingproject.business.service;

import dev.juancas.shippingproject.model.dto.AssociateDriverDto;
import dev.juancas.shippingproject.model.dto.DisAssociateDriverDto;
import dev.juancas.shippingproject.model.dto.SaveDriverDto;
import dev.juancas.shippingproject.model.entities.Driver;
import dev.juancas.shippingproject.model.repositories.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DriverServiceTest {

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverServiceImpl driverService;
    private Driver driver;
    private List<String> placas;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        driver = new Driver();

        driver.setIdentificacion("1007195132");
        driver.setNombre("Juanito");
        driver.setTelefono("3132296334");

        placas = new ArrayList<>();
        placas.add("DDJ806");
        placas.add("DDJ809");
        placas.add("DDJ804");
    }

    @Test
    void getDrivers() {
        when(driverRepository.findAll()).thenReturn(Arrays.asList(driver));
        assertNotNull(driverService.getDrivers());
    }

    @Test
    void newDriver() {
        when(driverRepository.save(any(Driver.class))).thenReturn(driver);
        assertNotNull(driverService.newDriver(new SaveDriverDto("1007195132","Juanito", "3132296334")));
    }

    @Test
    void toAssociateDriver() {
        assertNotNull(driverService.toAssociateDriver(new AssociateDriverDto("1007195132", placas)));
    }

    @Test
    void toDisAssociateDriver() {
        assertNotNull(driverService.toDisAssociateDriver(new DisAssociateDriverDto("1007195132","DDJ809")));

    }
}