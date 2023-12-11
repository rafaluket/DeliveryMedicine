package com.deliveryFarmacy.service;

import com.deliveryFarmacy.persistence.model.*;
import com.deliveryFarmacy.persistence.model.Farmacy;

import java.util.List;
import java.util.Optional;

public interface IFarmacyService {
    Farmacy saveFarmacy(Farmacy farmacy);

    List<Farmacy> getFarmacy(String farmacyName);

    List<Farmacy> findAll();

    Optional<Farmacy> findById(Long id);

    void deleteFarmacy(Farmacy farmacy);
}
