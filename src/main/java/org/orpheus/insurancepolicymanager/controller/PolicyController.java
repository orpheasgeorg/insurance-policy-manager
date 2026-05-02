package org.orpheus.insurancepolicymanager.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Policy;
import org.orpheus.insurancepolicymanager.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies(){
        List<Policy> saved = policyService.getAllPolicies();
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicy(@PathVariable Long id){
        Policy saved = policyService.getPolicyById(id);
        return ResponseEntity.ok(saved);
    }

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        Policy saved = policyService.createPolicy(policy);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping("/{status}/{id}")
    public Policy updatePolicy(@PathVariable String status, @PathVariable Long id) {
        return policyService.updatePolicy(status,id);
    }

}
