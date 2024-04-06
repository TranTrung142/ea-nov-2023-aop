package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Category;
import com.example.demo.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;
    public List<Address> findAll() {
        return addressRepo.findAll();
    }
    public Address findAddressById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }
}
