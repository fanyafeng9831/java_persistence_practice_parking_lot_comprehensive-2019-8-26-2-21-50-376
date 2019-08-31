package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Employee;


import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();
   void insert(@Param("employee") Employee employee);
   
   List<Employee> selectAllEmployees(@Param(value = "offSet") Integer offSet,@Param(value = "pageSize") Integer pageSize);
}
