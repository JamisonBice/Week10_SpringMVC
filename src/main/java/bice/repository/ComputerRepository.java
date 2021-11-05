package bice.repository;
/**
 * @author Jamison Bice - jdbice

 * CIS175 - Fall 2021
 * Oct 20, 2021
 */
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Oct 20, 2021
 */

import org.springframework.stereotype.Repository;
import bice.beans.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
