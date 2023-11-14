package edu.yacoubi.transaction.service;

import edu.yacoubi.transaction.dto.FlightBookingAcknowledgement;
import edu.yacoubi.transaction.dto.FlightBookingRequest;
import edu.yacoubi.transaction.model.Passenger;
import edu.yacoubi.transaction.model.Payment;
import edu.yacoubi.transaction.repository.PassengerRepository;
import edu.yacoubi.transaction.repository.PaymentRepository;
import edu.yacoubi.transaction.utils.PaymentUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlightBookingService {
    private final PassengerRepository passengerRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

        Passenger passenger = request.getPassenger();
        passenger = passengerRepository.save(passenger);

        Payment payment = request.getPayment();

        PaymentUtility.validateCreditLimit(
                payment.getAccountNumber(),
                passenger.getFare()
        );

        payment.setPassengerId(passenger.getPId());
        payment.setAmount(passenger.getFare());
        paymentRepository.save(payment);

        return new FlightBookingAcknowledgement(
                "SUCCESS",
                passenger.getFare(),
                UUID.randomUUID().toString().split("-")[0],
                passenger
        );
    }
}
