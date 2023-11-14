package edu.yacoubi.transaction.repository;

import edu.yacoubi.transaction.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
