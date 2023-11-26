package com.lsl.packageoftsal.hiberanatepack.repositoeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsl.packageoftsal.hiberanatepack.entities.PaymentEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
