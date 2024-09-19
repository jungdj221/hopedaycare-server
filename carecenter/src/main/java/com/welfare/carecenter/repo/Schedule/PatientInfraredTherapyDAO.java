package com.welfare.carecenter.repo.Schedule;

import com.welfare.carecenter.domain.Schedule.PatientInfraredTherapy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientInfraredTherapyDAO extends JpaRepository<PatientInfraredTherapy, Integer> {
}
