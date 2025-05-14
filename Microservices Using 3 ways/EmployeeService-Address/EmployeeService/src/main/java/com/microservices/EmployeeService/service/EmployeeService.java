package com.microservices.EmployeeService.service;

import java.util.Optional;

import javax.xml.crypto.Data;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.EmployeeService.configuration.AddressFeignClient;

import com.microservices.EmployeeService.entity.EmployeeEntity;
import com.microservices.EmployeeService.repository.EmployeeRepository;
import com.microservices.EmployeeService.response.AddressResponse;
import com.microservices.EmployeeService.response.EmployeeResponse;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
   private ModelMapper modelMapper;

    @Autowired
   private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private AddressFeignClient addressFeignClient;



    public EmployeeResponse getEmployeeById(int id){
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);
           EmployeeResponse employeeResponse= modelMapper.map(employeeEntity, EmployeeResponse.class);

//           AddressResponse addressResponse=restTemplate.getForObject("http://localhost:8082/api/address/Details/{id}",AddressResponse.class,id);
//           employeeResponse.setAddressResponse(addressResponse);
//        return employeeResponse;





//        AddressResponse addressResponse= webClient.get().uri("http://localhost:8082/api/address/Details/{id}",id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .block();
//        employeeResponse.setAddressResponse(addressResponse);
//           return employeeResponse;

//           // in this above i was not added any dependency for webclient because spring-web dependency
//        // contains the basic webclient features and also if our spring versioin is greater than 2.4
//        // we dont need any because we have spring-webflux but this depenc=dency aslo not present in our
//        // code but also it is working because of spring-web for basic spring WebClient.




        AddressResponse addressResponse=addressFeignClient.getAddress(id);
            employeeResponse.setAddressResponse(addressResponse);

            return employeeResponse;



        
        
        
        
//        Microservices Overview
//Overview of Microservices IN this i have took AddressService and the EmployeeServices as two diff projects,
//In the AddresssService i have created entity,response,controller,service,repository as the packages and
//in the i have used the Model mapping for assigninig of values to the response because we shouls initentianally
//send to the endusers what he requires other than the like id so i add model mapper dependency it contain map which 
//takes response fromrepository from above line and to the destination .class filse means response class so we
//get that output if we rrun the endpoint and in the EmployeeServiceI used the same like modelmapper dependency
//and used that here and i have configuration package means for maodel mapping and if any other we manually create
//there and here twointegrate two microservices we can used restemplate ,webClient,FIegnClient, Resttemplate means
//it is depricatedbut used in old projectsin this we created the field injectioin and we have getForObject which
//takes url,destinationclass file .class and the id and we in the response for this i created AddressResponse variable means
//i created the class too in the same appplication,
//and i used the restemplated got value and setted to that variable then it got returned
//In the WEbclient I have used the configuration int he configuration package with build without
//the new keyword and added dependency basically we dont need dependency because the web dependency 
//handles basics features of webclient like .block() but i have too the dependency and her i used the 
//retrieve means it sends the url request to the applicationn and get the response and in the  body.mono 
//is used to convert json into the object and block() is like doing async functio to syncronous for waiting
//certain time for excahneg Data.
//And next type is FiegnClient means created an interface which consits abstract emethod contains return type
//as the addressResponse and it contaisn the get url and the fiegnClient with the destinationn application name
//and the uri ie base urland i have added the @EnableFeignClients in the main file to scan the fignclients instead
//we can maually kepp configuration+bean
//and  addded dependency, this is not working because of bean not injected though i have done it but not working 
	



    }

}
