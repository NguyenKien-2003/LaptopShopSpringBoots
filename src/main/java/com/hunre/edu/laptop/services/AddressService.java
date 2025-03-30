package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.dtos.responses.ResponseMessage;
import com.hunre.edu.laptop.models.Address;

import java.util.List;

public interface AddressService {
    Address getPrimaryAddress(String username);
    List<Address> getAddressesByUser(String username);
    Address addAddress(String username, Address address);
    ResponseMessage deleteAddress(Long id);
    Address updateAddress(Long id, Address address);
    Address getAddressById(Long id);
    ResponseMessage changePrimaryAddress(Long id);
}
