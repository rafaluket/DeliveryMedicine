package com.deliveryFarmacy.web.controller;

import com.deliveryFarmacy.persistence.model.Delivery;
import com.deliveryFarmacy.persistence.model.Farmacy;
import com.deliveryFarmacy.persistence.model.Status;
import com.deliveryFarmacy.persistence.model.User;
import com.deliveryFarmacy.service.IDeliveryService;
import com.deliveryFarmacy.service.IFarmacyService;
import com.deliveryFarmacy.service.IUserService;
import com.deliveryFarmacy.web.dto.DeliveryDto;
import com.deliveryFarmacy.web.util.GenericResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class DeliveryController {

    @Autowired
    IDeliveryService deliveryService;

    @Autowired
    IFarmacyService farmacyService;

    @Autowired
    IUserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/entrega/saveDelivery")
    public GenericResponse saveDeliveries(@RequestBody ObjectNode jsonNodes, Authentication authUser) {
        LOGGER.info("Try to save delivery");
        //TODO: Get Delivery information (protocol + address)
        Delivery delivery = new Delivery();
        ObjectMapper mapper = new ObjectMapper();

        List<DeliveryDto> deliveriesDto =  mapper.convertValue(jsonNodes.get("deliveriesDto"), new TypeReference<List<DeliveryDto>>(){});
        String farmacyId =  mapper.convertValue(jsonNodes.get("farmacyId"), String.class);
        Farmacy farmacy = farmacyService.findById(Long.parseLong(farmacyId)).get();
        User user = (User) authUser.getPrincipal();

        for (DeliveryDto deliveryDto : deliveriesDto){
            delivery.setNumberProtocol(deliveryDto.getNumberProtocol());
            delivery.setAdress(deliveryDto.getAdress());
            delivery.setFarmacyOrigin(farmacy);
            delivery.setUser(userService.findUserByEmail(user.getEmail()));
            delivery.setStatus(Status.getEnumById(1));
            deliveryService.saveDelivery(delivery);
        }

        return new GenericResponse("success");
    }

    @GetMapping("/entrega/adicionar")
    public String deliveryAdd(final Model model) {
        LOGGER.debug("Rendering delivery registration page.");
        final DeliveryDto delivery = new DeliveryDto();
        final List<Farmacy> farmacies = farmacyService.findAll();

        model.addAttribute("delivery", delivery);
        model.addAttribute("farmacies", farmacies);
        return "registrationDelivery";
    }
}
