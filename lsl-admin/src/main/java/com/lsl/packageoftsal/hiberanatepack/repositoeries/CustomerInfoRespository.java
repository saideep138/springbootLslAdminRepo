package com.lsl.packageoftsal.hiberanatepack.repositoeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lsl.packageoftsal.hiberanatepack.entities.CustomerInfoEntity;

@Repository
public interface CustomerInfoRespository extends JpaRepository<CustomerInfoEntity, Long> {
	
	@Query("from CustomerInfoEntity where id>?1 and id<?2 order by customerName")
	List<CustomerInfoEntity> findById(int id,int idEnd);

}
