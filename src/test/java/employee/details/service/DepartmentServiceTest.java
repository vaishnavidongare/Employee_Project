
package employee.details.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import employee.details.entity.Department;
import employee.details.repository.DepartmentRepo;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
	@Mock
	private DepartmentRepo dpRepo;

	@Autowired
	private DepartmentService dpService;

	@BeforeEach
	void setUp() {
		this.dpService = new DepartmentService(this.dpRepo);
	}

	@Test
	void getAllEmp() {
		dpService.getAllDepartment();
		verify(dpRepo).findAll();
	}

	@Test
	void getDepartmentById() {
		//Integer id = 1;
		String name ="IT";
		Optional<Department> dp = dpService.getDepartmentById(1);
		// verify(dpRepo).findById(id);
		// verify(dpRepo).findAll();
		assertNotNull(dpRepo.findById(1).getName());
	}

}
