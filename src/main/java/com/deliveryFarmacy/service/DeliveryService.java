package com.deliveryFarmacy.service;

import com.deliveryFarmacy.persistence.dao.DeliveryRepository;
import com.deliveryFarmacy.persistence.model.Delivery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DeliveryService implements IDeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    // API

    @Override
    public Delivery saveDelivery(final Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }


}
