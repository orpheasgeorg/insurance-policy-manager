package org.orpheus.insurancepolicymanager.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Claim;
import org.orpheus.insurancepolicymanager.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/claims")
public class ClaimController {

    final private ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim saved = claimService.createClaim(claim);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> saved = claimService.getAllClaims();
        return ResponseEntity.ok(saved);
    }

    @GetMapping("{customer_id}")
    public ResponseEntity<List<Claim>> getClaimByCustomerId(@PathVariable("customer_id") Long customerId) {
        List<Claim> saved = claimService.getClaimByCustomerId(customerId);

        return ResponseEntity.ok(saved);
    }


}
