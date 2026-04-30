package org.orpheus.insurancepolicymanager.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Policy;
import org.orpheus.insurancepolicymanager.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
    @RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies(){
        List<Policy> saved = policyService.getAllPolicies();
        return ResponseEntity.status(HttpStatus.FOUND).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Policy>> getPolicy(@PathVariable Long id){
        Optional<Policy> saved = policyService.getPolicyById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(saved);
    }


    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        Policy saved = policyService.createPolicy(policy);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
