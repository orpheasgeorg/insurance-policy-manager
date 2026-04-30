package org.orpheus.insurancepolicymanager.service;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Customer;
import org.orpheus.insurancepolicymanager.model.Policy;
import org.orpheus.insurancepolicymanager.repository.CustomerRepository;
import org.orpheus.insurancepolicymanager.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyService {


    final private PolicyRepository policyRepository;
    private final CustomerRepository customerRepository;

    public Optional<Policy> getPolicyById(Long id){
        return policyRepository.findById(id);
    }

    public List<Policy> getAllPolicies(){
        return policyRepository.findAll();
    }


    public Policy createPolicy(Policy policy) {
        Customer customer = customerRepository.findById(policy.getCustomer().getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        policy.setCustomer(customer);
        return policyRepository.save(policy);
    }
}
