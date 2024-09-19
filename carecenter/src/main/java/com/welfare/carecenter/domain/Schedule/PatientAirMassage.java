package com.welfare.carecenter.domain.Schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.welfare.carecenter.domain.User.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@Builder
@Table(name = "patient_air_massage")
public class PatientAirMassage {
    @Id
    @Column(name = "massage_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int massageListId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "massage_patient_id")
    private Patient patient; // 왜래키 필요

    @Column(name = "patient_treatment_date")
    private String patientTreatmentDate;
}
