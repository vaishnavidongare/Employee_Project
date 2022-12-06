package employee.details.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.details.dto.EmployeeRequest;
import employee.details.entity.Department;
import employee.details.entity.Employee;
import employee.details.service.DepartmentService;
import employee.details.service.EmployeeService;

@RestController
@RequestMapping(value="/api/employee")
public class EmployeeController {
     @Autowired
     private EmployeeService emps;
     @Autowired
     private DepartmentService dps;
     
     //To Add employee
     @PostMapping
		public Employee addEmployee(@RequestBody EmployeeRequest empr ) {
			
			return emps.addEmployee(empr);
		}
     
     //To get all employees
	 @GetMapping
	 public List<Employee> getAllEmployee(){
			return this.emps.getAllEmployee();
		}
	 
	 //To get employee by Id
	 @GetMapping("/{id}")
		public Optional<Employee> getEmployeeById(@PathVariable ("id")  int id) {
		 return  this.emps.getEmployeeById(id);
		}
	 
	 //To update employee by id
	 @PutMapping("/{id}")
	    public void updateEmployee(@PathVariable String id,  @RequestBody Employee employee) {
		 emps.updateEmployee(id,employee);
		}
	 
	 //To delete employee and address  by emp id
	 @DeleteMapping("/{id}")
	 public void deleteEmp(@PathVariable ("id") int id) {
	     emps.deleteEmp(id);
	 }
	
	
	 
}
