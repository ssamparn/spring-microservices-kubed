package com.microservices.kubed.customerloan.repository;

import com.microservices.kubed.customerloan.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoansDataRepository extends JpaRepository<LoanEntity, Long> {
    List<LoanEntity> findByCustomerIdOrderByStartDateDesc(int customerId);
}
