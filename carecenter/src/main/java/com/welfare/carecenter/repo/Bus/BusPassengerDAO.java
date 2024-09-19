package com.welfare.carecenter.repo.Bus;

import com.welfare.carecenter.domain.Bus.BusPassenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusPassengerDAO extends JpaRepository<BusPassenger, Integer> {
}
