package org.orpheus.insurancepolicymanager.repository;

import org.orpheus.insurancepolicymanager.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {


}
