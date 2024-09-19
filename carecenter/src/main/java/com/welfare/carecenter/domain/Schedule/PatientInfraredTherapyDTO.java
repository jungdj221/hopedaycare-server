package com.welfare.carecenter.domain.Schedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientInfraredTherapyDTO {

    private int therapyListId;
    private int patientId;
    private String therapyPatientName;
    private String patientTreatmentDate;
}
