package com.deliveryFarmacy.persistence.dao;

import com.deliveryFarmacy.persistence.model.User;
import com.deliveryFarmacy.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);

}
