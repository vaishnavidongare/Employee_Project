package employee.details.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import employee.details.entity.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	Department findById(int dept_id);

	@Query("SELECT CASE WHEN COUNT(d) > 0 THEN TRUE ELSE FALSE END FROM Department d WHERE d.id = ?1")
	Boolean isDepartmentExistById(Integer id);

}
