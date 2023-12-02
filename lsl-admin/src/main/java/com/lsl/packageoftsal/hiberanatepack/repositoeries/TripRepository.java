package com.lsl.packageoftsal.hiberanatepack.repositoeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsl.packageoftsal.hiberanatepack.entities.TripEntity;

@Repository
public interface TripRepository extends JpaRepository<TripEntity,Long>{

}
/*

 
@Entity annotation defines that a class can be mapped to a table, it is just a marker, 
Entity is an object representing (usually) a row in a db. 
 
@Repository annotation defines CRUD operation on table
 
*/