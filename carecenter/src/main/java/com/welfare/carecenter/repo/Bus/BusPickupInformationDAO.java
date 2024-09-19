package com.welfare.carecenter.repo.Bus;

import com.welfare.carecenter.domain.Bus.BusPickupInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusPickupInformationDAO extends JpaRepository<BusPickupInformation, Integer> {
}
