package employee.details.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import employee.details.entity.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeRepoTest {
	@Autowired
	private EmployeeRepo empRepo;

	@Test
	void isDepartmentExistById() {
		Employee dep = new Employee(3, "Manish", "Developer", 45000l);
		empRepo.save(dep);
		Boolean actualResult = empRepo.isEmployeeExistById(3);
		assertThat(actualResult).isTrue();
	}


	@AfterEach
	void tearDown() {
		System.out.println("tearing down");
		empRepo.deleteAll();
	}

	@BeforeEach
	void setUp() {
		System.out.println("setting up");
	}
}
