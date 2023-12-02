package com.lsl.packageoftsal.mybatis.xmlmapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lsl.packageoftsal.mybatis.model.FlightModel;


@Mapper
public interface FlightXmlMapper {

    int inserted(FlightModel flight);

    List<FlightModel> findAll();

    FlightModel findById(@Param("id") long id);

    int update(FlightModel flight);
    
    int deleteById(@Param("id") long id);
}

/*
 * 
#Configure the xml Mapping path
mybatis.mapper-locations=classpath:mapper.*.xml
 * */