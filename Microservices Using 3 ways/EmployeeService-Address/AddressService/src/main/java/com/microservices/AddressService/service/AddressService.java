package com.microservices.AddressService.service;

import com.microservices.AddressService.entity.AddressEntity;
import com.microservices.AddressService.repository.AddressRepository;
import com.microservices.AddressService.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
   private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse getAddressByEmpId(int id){

        Optional<AddressEntity> addressEntity=addressRepository.findEmployeeServiceAndAddress(id);
                return modelMapper.map(addressEntity, AddressResponse.class);
    }
}
