package org.orpheus.insurancepolicymanager.service;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.model.Customer;
import org.orpheus.insurancepolicymanager.model.Policy;
import org.orpheus.insurancepolicymanager.model.PolicyStatus;
import org.orpheus.insurancepolicymanager.repository.CustomerRepository;
import org.orpheus.insurancepolicymanager.repository.PolicyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyService {


    final private PolicyRepository policyRepository;
    private final CustomerRepository customerRepository;

    public Policy getPolicyById(Long id){
        return policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
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

    public Policy updatePolicy (@PathVariable String status, @PathVariable Long id)
    {
        Policy existing =  policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        existing.setPolicyStatus(PolicyStatus.valueOf(status));

        return policyRepository.save(existing);
    }



}
