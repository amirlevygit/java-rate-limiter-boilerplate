package com.fireblocks.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
    public List<TransactionEntity> findByUserId(String userId);
    public TransactionEntity findByIdAndUserId(String id, String userId);
}