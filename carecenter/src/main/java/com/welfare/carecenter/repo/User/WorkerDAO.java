package com.welfare.carecenter.repo.User;

import com.welfare.carecenter.domain.User.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerDAO extends JpaRepository<Worker, Integer> {
}
