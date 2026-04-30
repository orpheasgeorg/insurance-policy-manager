package org.orpheus.insurancepolicymanager.repository;

import org.orpheus.insurancepolicymanager.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
