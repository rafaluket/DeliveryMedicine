package com.deliveryFarmacy.persistence.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "farmacy")
public class Farmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String farmacyName;
    private String farmacyCityName;
    private String description;

    @OneToMany(mappedBy = "farmacyOrigin")
    private Collection<Delivery> deliveries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarmacyName() {
        return farmacyName;
    }

    public void setFarmacyName(String farmacyName) {
        this.farmacyName = farmacyName;
    }

    public String getFarmacyCityName() {
        return farmacyCityName;
    }

    public void setFarmacyCityName(String farmacyCityName) {
        this.farmacyCityName = farmacyCityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
