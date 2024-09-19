package com.welfare.carecenter.domain.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicInsert
@Builder
@Table(name = "worker")
public class Worker {
    @Id
    @Column(name = "worker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workerId;

    @Column(name = "worker_name")
    private String workerName;

    @Column(name = "worker_info")
    private String workerInfo;

    @Column(name = "worker_roll")
    private String workerRoll;
}
