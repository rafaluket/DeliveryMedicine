package com.deliveryFarmacy.web.controller;

import com.deliveryFarmacy.persistence.model.Farmacy;
import com.deliveryFarmacy.service.IFarmacyService;
import com.deliveryFarmacy.web.util.GenericResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
public class FarmacyController {

    @Autowired
    IFarmacyService farmacyService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/farmacia/saveFarmacy")
    public GenericResponse saveFarmacy(@Valid Farmacy farmacy) {
        LOGGER.debug("try to save farmacy");
        farmacyService.saveFarmacy(farmacy);
        return new GenericResponse("success");
    }

    @GetMapping("/farmacia/adicionar")
    public String farmaciaAdicionar(final Locale locale, final Model model) {
        LOGGER.debug("Rendering farmacy registration page.");
        final Farmacy farmacy = new Farmacy();
        model.addAttribute("farmacy", farmacy);
        return "registrationFarmacy";
    }
}
