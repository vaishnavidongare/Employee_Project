package employee.details.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import employee.details.entity.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DepartmentRepoTest {

	@Autowired
	private DepartmentRepo depRepo;

	@Test
	void isDepartmentExistById() {
		Department dep = new Department(3, "IT");
		depRepo.save(dep);
		Boolean actualResult = depRepo.isDepartmentExistById(3);
		//assertThat(actualResult).isTrue();
		assertTrue(actualResult);
	}

	@AfterEach
	void tearDown() {
		System.out.println("tearing down");
		depRepo.deleteAll();
	}

	@BeforeEach
	void setUp() {
		System.out.println("setting up");
	}
}