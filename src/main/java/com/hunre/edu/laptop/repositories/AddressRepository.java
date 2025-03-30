package com.hunre.edu.laptop.repositories;

import com.hunre.edu.laptop.models.Address;
import com.hunre.edu.laptop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUser(User user);
    Address findByUserAndPrimaryAddressTrue(User user);
}