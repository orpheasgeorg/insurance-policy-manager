package org.orpheus.insurancepolicymanager.service;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Claim;
import org.orpheus.insurancepolicymanager.model.Policy;
import org.orpheus.insurancepolicymanager.model.PolicyStatus;
import org.orpheus.insurancepolicymanager.repository.ClaimRepository;
import org.orpheus.insurancepolicymanager.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final PolicyRepository policyRepository;

    public Claim createClaim(Claim claim){

        Policy saved_policy = policyRepository.findById(claim.getPolicy().getId()).orElseThrow(() -> new RuntimeException("Policy not found"));

        if (saved_policy.getPolicyStatus() != PolicyStatus.ACTIVE){
            throw new IllegalStateException("Policy is not active.");
        }
        else{
            return claimRepository.save(claim);
        }
    }

    public List<Claim> getAllClaims(){
        return claimRepository.findAll();
    }

    public List<Claim> getClaimByCustomerId(Long customerId){
        List<Claim> saved_claims = claimRepository.findByPolicy_Customer_CustomerId(customerId);
        return saved_claims;
    }

}
