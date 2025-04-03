package pl.knap.shop.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.knap.shop.order.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}