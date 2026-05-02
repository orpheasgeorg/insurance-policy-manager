package org.orpheus.insurancepolicymanager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Customer;
import org.orpheus.insurancepolicymanager.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer (@Valid @RequestBody Customer customer){
        Customer saved = customerService.createCustomer(customer);
        return ResponseEntity.ok(saved);
    }

}
