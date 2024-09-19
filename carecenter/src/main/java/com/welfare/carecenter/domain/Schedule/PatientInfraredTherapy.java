package com.welfare.carecenter.domain.Schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.welfare.carecenter.domain.User.Patient;
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
@Table(name = "patient_infrared_therapy")
public class PatientInfraredTherapy {
    @Id
    @Column(name = "therapy_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int therapyListId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "therapy_patient_id") // connect foreign key
    private Patient patient;

    @Column(name = "patient_treatment_date")
    private String patientTreatmentDate;

}
