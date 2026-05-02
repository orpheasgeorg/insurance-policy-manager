package org.orpheus.insurancepolicymanager.repository;

import org.orpheus.insurancepolicymanager.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findByPolicy_Customer_CustomerId(Long customerId);

}
