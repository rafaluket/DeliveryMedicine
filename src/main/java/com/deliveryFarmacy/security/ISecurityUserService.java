package com.deliveryFarmacy.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(String token);

}
