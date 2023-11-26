package com.lsl.packageoftsal.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lsl.packageoftsal.mybatis.model.FlightModel;


public interface FlightMapper {
	@Insert("INSERT INTO flight(flightName,capacity) " +
            " VALUES (#{flightName}, #{capacity})")
    int insert(FlightModel flight);

    @Select("SELECT * FROM flight")
    List<FlightModel> findAll();

    @Select("SELECT * FROM flight WHERE flightID = #{id}")
    FlightModel findById(@Param("id") long id);

    @Update("Update flight set flightName=#{flightName}, " +
            " capacity=#{capacity}, flightID = #{varflightID} where flightID=#{flightID}")
    int update(FlightModel flight);

    @Delete("DELETE FROM flight WHERE flightID = #{id}")
    int deleteById(@Param("id") long id);
}
//flightID|flightName|capacity