package dev.juancas.shippingproject.model.repositories;

import dev.juancas.shippingproject.model.entities.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdentificacion(String identificacion);
    Optional<Driver> findByTelefono(String telefono);
    @Query(value = "SELECT d.* FROM driver d JOIN vehicle v ON v.conductor_id = d.id ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Driver> findRand();
}
