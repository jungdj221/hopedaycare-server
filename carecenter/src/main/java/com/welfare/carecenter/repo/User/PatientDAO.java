package com.welfare.carecenter.repo.User;

import com.welfare.carecenter.domain.User.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDAO extends JpaRepository<Patient, Integer> {
}