package com.welfare.carecenter.domain.Bus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Builder
@Table(name = "bus_passenger")
public class BusPassenger {
    @Id
    @Column(name = "bus_passenger_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busPassengerId;

    //평균 픽업 시간
    @Column(name = "bus_avg_time")
    private String busAvgTime; // string 값으로 받고 front 에서 조건처리

    @Column(name = "bus_passenger_name")
    private String busPassengerName;

    // 언제쯤 전화할지
    @Column(name = "bus_call_timing")
    private String busCallTiming;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "b_bus_id", referencedColumnName = "bus_id") // foreign key
    private BusPickupInformation busPickupInformation;

    // 오전 , 오후 송영 여부 : char(2)
    @Column(name = "bus_status")
    private String busStatus;
}
