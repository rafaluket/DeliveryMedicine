package com.deliveryFarmacy.service;

import com.deliveryFarmacy.persistence.model.Delivery;

import java.util.List;

public interface IDeliveryService {
    Delivery saveDelivery(Delivery delivery);

    List<Delivery> getAllDeliveries();
}
