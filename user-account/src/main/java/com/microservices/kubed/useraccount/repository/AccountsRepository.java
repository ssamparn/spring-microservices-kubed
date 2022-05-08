package com.microservices.kubed.useraccount.repository;

import com.microservices.kubed.useraccount.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {
    AccountsEntity findByCustomerId(int customerId);
}
