package com.deliveryFarmacy.persistence.dao;

import com.deliveryFarmacy.persistence.model.NewLocationToken;
import com.deliveryFarmacy.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {

    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(UserLocation userLocation);

}
