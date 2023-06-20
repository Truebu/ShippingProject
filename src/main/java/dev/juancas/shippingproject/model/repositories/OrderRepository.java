package dev.juancas.shippingproject.model.repositories;

import dev.juancas.shippingproject.model.entities.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {
}
