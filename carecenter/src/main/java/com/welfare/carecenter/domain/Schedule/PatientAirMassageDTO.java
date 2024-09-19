package com.welfare.carecenter.domain.Schedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientAirMassageDTO {

    private int massageListId;
    private int patientId;
    private String patientName;
    private String patientTreatmentDate;
}
