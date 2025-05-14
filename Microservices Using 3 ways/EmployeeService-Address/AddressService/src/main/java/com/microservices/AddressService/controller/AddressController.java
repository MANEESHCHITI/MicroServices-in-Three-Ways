package com.microservices.AddressService.controller;

import com.microservices.AddressService.response.AddressResponse;
import com.microservices.AddressService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/Details/{id}")
    public ResponseEntity<AddressResponse>  getAddDetails(@PathVariable("id") int id){

        AddressResponse addressResponse=addressService.getAddressByEmpId(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);

    }
}
