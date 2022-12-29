package employee.details.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.details.dto.EmployeeRequest;
import employee.details.entity.Address;
import employee.details.entity.Department;
import employee.details.entity.Employee;
import employee.details.repository.DepartmentRepo;
import employee.details.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo emps;
	@Autowired
	private DepartmentRepo dprepo;

	public List<Employee> getAllEmployee() {

		List<Employee> employee = new ArrayList<>();
		emps.findAll().forEach(employee::add);
		return employee;
	}

	public EmployeeService(EmployeeRepo emps) {
		super();
		this.emps = emps;
	}

	public Employee addEmployee(EmployeeRequest empr) {
		Department department = dprepo.findById(empr.dept_id);
		Employee empl = new Employee();
		empl.setName(empr.name);
		empl.setDes(empr.des);
		empl.setSalary(empr.salary);
		empl.setDepartment(department);
		return emps.save(empl);
	}

	public Optional<Employee> getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> e = emps.findById(id);
		return e;
	}

	public void updateEmployee(String id, Employee employee) {

		String position = employee.getDes();
		String name = employee.getName();
		Long salary = employee.getSalary();
		emps.saveEmpdetail(id, position, name, salary);
	}

	public void deleteEmp(int id) {
		emps.deleteById(id);
	}

}
