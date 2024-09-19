package com.welfare.carecenter.domain.User;

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
@Table(name = "patient_absence")
public class PatientAbsence {
    @Id
    @Column(name = "absence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int absenceId;

    @ManyToOne
    @JoinColumn(name = "absence_user_id")
    private Patient patient;

    @Column(name = "absence_date")
    private String absenceDate;
}
