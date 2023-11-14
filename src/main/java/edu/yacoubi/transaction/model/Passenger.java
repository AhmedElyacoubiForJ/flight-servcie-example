package edu.yacoubi.transaction.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PASSENGER_INFO")
public class Passenger {
    @Id
    @GeneratedValue
    private Long pId;

    private String name;
    private String email;
    private String source;
    private String destination;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-mm-yyy"
    )
    private Date travelDate;
    private String pickupTime;
    private String arrivalTime;
    private Double fare;
}
