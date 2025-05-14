package com.microservices.EmployeeService.configuration;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.EmployeeService.response.AddressResponse;

@Configuration
@FeignClient(name = "AddressService", url = "http://localhost:8082")
public interface AddressFeignClient {
    
	@Bean
    @GetMapping("/api/address/Details/{id}")
    AddressResponse getAddress(@PathVariable("id") int id);
}
