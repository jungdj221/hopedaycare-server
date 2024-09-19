package com.welfare.carecenter.repo.Schedule;

import com.welfare.carecenter.domain.Schedule.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassScheduleDAO extends JpaRepository<ClassSchedule, Integer> {
}
