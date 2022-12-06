package employee.details.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.details.entity.Department;
import employee.details.entity.Employee;
import employee.details.repository.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	public DepartmentRepo dept;

	public void addDepartment(Department department) {
		dept.save(department);
		
	}

   public List<Department> getAllDepartment(){
		List<Department> department = new ArrayList<>();
		dept.findAll().forEach(department::add);
		return department;
	}
   public void updateDepartment(String id, Department department) {
		dept.save(department);
		
	}
   public Optional<Department> getDepartmentById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Department> e = dept.findById(id);
		return e;
	}

}
