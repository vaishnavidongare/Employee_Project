package employee.details;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import employee.details.entity.Department;
import employee.details.repository.DepartmentRepo;

@SpringBootTest
class DetailsApplicationTests {

	@Autowired
	DepartmentRepo drepo;
	
	
	@Test
    public void addDepartmentDetail() {
		Department department = new Department();
		department.setId(1);
		department.setName("July");
		drepo.save(department);
		assertNotNull(drepo.findById(1).getId());
	}

}
