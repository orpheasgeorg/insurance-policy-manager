package org.orpheus.insurancepolicymanager.controller;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Claim;
import org.orpheus.insurancepolicymanager.service.ClaimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/claims")
public class ClaimController {

    final private ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim saved = claimService.createClaim(claim);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


}
