package com.lsl.packageoftsal.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lsl.packageoftsal.mybatis.model.FlightModel;

@Mapper
public interface FlightMapper {
	@Insert("INSERT INTO flight(flight_Name,capacity,flightId) " +
            " VALUES (#{flightName}, #{capacity}, #{flightId})")
    int insert(FlightModel flight);

    @Select("SELECT * FROM flight")
    List<FlightModel> findAll();

    @Select("SELECT * FROM flight WHERE flightID = #{id}")
    FlightModel findById(@Param("id") long id);

    @Update("Update flight set flight_Name=#{flightName}, " +
            " capacity=#{capacity}, flightID = #{varflightID} where flightID=#{flightID}")
    int update(FlightModel flight);

    @Delete("DELETE FROM flight WHERE flightID = #{id}")
    int deleteById(@Param("id") long id);
    
    //TODO
    @Select("SELECT * FROM flight_seq")
    Long getSequenceNumber();
    
    @Update("Update flight_seq set next_val=#{tonum} " +
            " where next_val=#{fromnum}")
    int updateSequence(@Param("fromnum") long from,@Param("tonum") long to);
    /*
    Hibernate: select next_val as id_val from flight_seq for update
	Hibernate: update flight_seq set next_val= ? where next_val=?
	Hibernate: insert into flight (capacity,flight_name,flightid) values (?,?,?)
     */
}
//flightID|flightName|capacity