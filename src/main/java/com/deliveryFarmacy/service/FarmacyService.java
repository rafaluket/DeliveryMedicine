package com.deliveryFarmacy.service;

import com.deliveryFarmacy.persistence.dao.*;
import com.deliveryFarmacy.persistence.model.*;
import com.deliveryFarmacy.persistence.dao.FarmacyRepository;
import com.deliveryFarmacy.persistence.model.Farmacy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FarmacyService implements IFarmacyService {

    @Autowired
    private FarmacyRepository farmacyRepository;

    // API

    @Override
    public Farmacy saveFarmacy(final Farmacy farmacy) {
        return farmacyRepository.save(farmacy);
    }

    @Override
    public List<Farmacy> getFarmacy(final String farmacyName) {
        return farmacyRepository.findByFarmacyName(farmacyName);
    }

    @Override
    public List<Farmacy> findAll() {
        return farmacyRepository.findAll();
    }

    @Override
    public Optional<Farmacy> findById(Long id) {
        return farmacyRepository.findById(id);
    }

    @Override
    public void deleteFarmacy(final Farmacy farmacy) {
        farmacyRepository.delete(farmacy);
    }
}
