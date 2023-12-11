package com.deliveryFarmacy.web.dto;

import com.deliveryFarmacy.persistence.model.Adress;
import com.deliveryFarmacy.validation.PasswordMatches;

@PasswordMatches
public class DeliveryDto {

    private String numberProtocol;

    private Adress adress;

    public String getNumberProtocol() {
        return numberProtocol;
    }

    public void setNumberProtocol(String numberProtocol) {
        this.numberProtocol = numberProtocol;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
