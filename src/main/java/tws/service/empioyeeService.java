package tws.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class empioyeeService {
	@Autowired
	@Mapper
	private EmployeeMapper employeeMapper;
	public List<Employee> selectEmployee(){
		List<Employee> employee = employeeMapper.selectAll();
		for(int i=0;i<employee.size();i++) {
			String employeeName = "中原银行";
			employee.get(i).setName(employeeName+employee.get(i));
		}
		return employee;
	}
	public List<Employee> selcectAllEmployee(Integer page,Integer pageSize){
		if (page != null && pageSize != null) {
			int offSet = (page-1) * pageSize;
			return employeeMapper.selectAllEmployees(offSet, pageSize);
		}
		return employeeMapper.selectAll();
	}
	

}
