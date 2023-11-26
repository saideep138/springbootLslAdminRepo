package com.lsl.packageoftsal.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lsl.packageoftsal.mybatis.model.EmployeeModel;

@Mapper
public interface EmployeeMapper {
	
	@Insert("INSERT INTO employee(empname,empid,erole,esalary) " +
            " VALUES (#{varempname}, #{varempid}, #{erole}, #{esalary})")
    int insert(EmployeeModel employee);

    @Select("SELECT * FROM employee")
    List<EmployeeModel> findAll();

    @Select("SELECT * FROM employee WHERE empid = #{id}")
    EmployeeModel findById(@Param("id") long id);

    @Update("Update employee set empname=#{varempname}, " +
            " erole=#{erole}, esalary=#{esalary}, empid = #{varempid} where empid=#{varempid}")
    int update(EmployeeModel employee);

    @Delete("DELETE FROM employee WHERE empid = #{id}")
    int deleteById(@Param("id") long id);
}
