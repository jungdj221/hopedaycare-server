package com.welfare.carecenter.repo.Bus;

import com.welfare.carecenter.domain.Bus.BusSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusSeatsDAO extends JpaRepository<BusSeats, Integer> {
}
