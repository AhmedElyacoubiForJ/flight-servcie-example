package edu.yacoubi.transaction.repository;

import edu.yacoubi.transaction.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
