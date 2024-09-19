package com.welfare.carecenter.domain.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicInsert
@Builder
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_info")
    private String patientInfo;

    // 어르신 졸업 여부
    @Column(name = "patient_status")
    private String patientStatus;

    // 졸업 날짜
    @Column(name = "patient_graduation_date")
    private String patientGraduationDate;
}
