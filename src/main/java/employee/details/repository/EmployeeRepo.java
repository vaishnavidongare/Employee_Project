package employee.details.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import employee.details.entity.Address;
import employee.details.entity.Department;
import employee.details.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>  {
	Employee findById(int emp_id);	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Employees u SET u.position=:position,u.name=:name,u.salary=:salary WHERE u.id = :id",nativeQuery = true)
	void saveEmpdetail(String id, String position, String name, Long salary);

}
