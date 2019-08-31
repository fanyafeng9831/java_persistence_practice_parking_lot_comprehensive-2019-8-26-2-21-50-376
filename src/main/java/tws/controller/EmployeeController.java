package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.empioyeeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")

public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private empioyeeService empioyeeservice;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }

    @PostMapping("")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
        employeeMapper.insert(employee);
        return ResponseEntity.created(URI.create("/employees/" + employee.getId())).body(employee);
    }
    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll(@RequestParam(value="page",required=false) Integer page,@RequestParam(value="pageSize",required=false) Integer pageSize) {
    	return ResponseEntity.ok(empioyeeservice.selcectAllEmployee(page,pageSize));
    }
}
