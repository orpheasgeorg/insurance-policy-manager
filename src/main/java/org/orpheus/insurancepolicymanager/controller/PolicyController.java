package org.orpheus.insurancepolicymanager.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Policy;
import org.orpheus.insurancepolicymanager.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
    @RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        Policy saved = policyService.createPolicy(policy);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
