package org.orpheus.insurancepolicymanager.security.con_ser_rep;

import org.orpheus.insurancepolicymanager.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    User findByUsername(String username);
}
