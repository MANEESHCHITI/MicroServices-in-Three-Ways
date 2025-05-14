package com.microservices.AddressService.repository;

import com.microservices.AddressService.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {


    @Query(nativeQuery = true,value="select ea.ids,ea.city,ea.state from empaddress01 ea join employeeservice01 es on ea.ids=es.id where ea.ids=:empid")
    public Optional<AddressEntity> findEmployeeServiceAndAddress(@Param("empid") int empid);
}
