package com.welfare.carecenter.domain.Bus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Builder
@Table(name = "bus_pickup_information")
public class BusPickupInformation {
    @Id
    @Column(name = "bus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busId; // 뒷번호만

    @Column(name = "bus_number")
    private int busNumber; //차량번호

    @Column(name = "bus_vehicle_name")
    private String busVehicleName;

    @Column(name = "bus_driver")
    private String busDriver;

    @Column(name = "bus_sub_driver")
    private String busSubDriver;

    @Column(name = "bus_helper")
    private String busHelper;

    @Column(name = "bus_sub_helper")
    private String busSubHelper;
}
