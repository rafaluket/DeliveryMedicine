package com.deliveryFarmacy.persistence.dao;

import com.deliveryFarmacy.persistence.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    @Override
    void delete(Delivery farmacy);

}
