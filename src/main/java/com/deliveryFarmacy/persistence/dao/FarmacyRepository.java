package com.deliveryFarmacy.persistence.dao;

import com.deliveryFarmacy.persistence.model.Farmacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmacyRepository extends JpaRepository<Farmacy, Long> {

    List<Farmacy> findByFarmacyName(String farmacyName);

    @Override
    void delete(Farmacy farmacy);

}
