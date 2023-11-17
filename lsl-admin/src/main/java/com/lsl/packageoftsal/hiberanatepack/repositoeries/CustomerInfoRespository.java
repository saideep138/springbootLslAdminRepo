package com.lsl.packageoftsal.hiberanatepack.repositoeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;

@Repository
public interface CustomerInfoRespository extends JpaRepository<CustomerInfoEntity, Long> {

}
