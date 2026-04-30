package org.orpheus.insurancepolicymanager.repository;

import org.orpheus.insurancepolicymanager.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
