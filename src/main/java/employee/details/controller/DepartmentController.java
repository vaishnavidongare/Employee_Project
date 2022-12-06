package employee.details.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.details.entity.Department;
import employee.details.entity.Employee;
import employee.details.service.DepartmentService;

@RestController
@RequestMapping(value="/api/department")
public class DepartmentController {
	 @Autowired
	 private DepartmentService depts;
	 
	 //To Create new department
	 @PostMapping
		public void addDepartment(@RequestBody Department department) {
			
			depts.addDepartment(department);
		}
	 
	 //To get all departments
	 @GetMapping
	 public List<Department> getAllDepartment(){
			return depts.getAllDepartment();
		}
	 
	 //To update department by Id
	 @PutMapping("/{id}")
	    public void updateDepartment(@PathVariable String id,  @RequestBody Department department) {
		 depts.updateDepartment(id,department);
		}
	 
	 //To get department by Id
	 @GetMapping("/{id}")
		public Optional<Department> getDepartmentById(@PathVariable ("id")  int id) {
		 return  this.depts.getDepartmentById(id);
		}
	
}
