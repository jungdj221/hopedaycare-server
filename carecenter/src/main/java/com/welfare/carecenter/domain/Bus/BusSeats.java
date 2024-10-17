package com.welfare.carecenter.domain.Bus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bus_seats")
public class BusSeats {
    @Id
    @Column(name = "bus_seat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busSeatId;

    @Column(name = "bus_seat_status")
    private String busSeatStatus;

    @ManyToOne
    @JoinColumn(name = "b_bus_id", referencedColumnName = "bus_id")
    private BusPickupInformation busPickupInformation;
}

/*
CREATE TABLE bus_seats(
	bus_seat_id INT PRIMARY KEY AUTO_INCREMENT,
    bus_seat_status VARCHAR(10), -- 미정, 사용불가, 사용 기능.
    bus_id INT -- foreign key
);
* */
