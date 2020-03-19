package org.nerdcore.flightcustomerservice.repositories;

import org.nerdcore.flightcustomerservice.entities.UserPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository(value="userPrincipalRepository")
@Transactional
public interface UserPrincipalRepository extends JpaRepository<UserPrincipal, Long> {

}
