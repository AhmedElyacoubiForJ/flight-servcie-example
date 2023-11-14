package edu.yacoubi.transaction.dto;

import edu.yacoubi.transaction.model.Passenger;
import edu.yacoubi.transaction.model.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private Passenger passenger;
    private Payment payment;
}
