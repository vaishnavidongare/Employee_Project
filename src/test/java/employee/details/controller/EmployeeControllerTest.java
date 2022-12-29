package employee.details.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import employee.details.entity.Employee;
import employee.details.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
	@Autowired
	private EmployeeController empController;

	@Mock
	private RequestAttributes attribute;

	@Mock
	private EmployeeService empService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		RequestContextHolder.setRequestAttributes(attribute);
		this.mockMvc = MockMvcBuilders.standaloneSetup(empController).build();
	}

	@Test
	public void getAllPerson() {
		int personId = 23;
		String personName = "Aman";
		String city = "Pune";
		List<Employee> p = new ArrayList<>();
		Mockito.when(empService.getAllEmployee()).thenReturn(p);
		Assert.assertNotNull(empController.getAllEmployee());
		Assert.assertNotNull(p);
		Assert.assertNotNull(personId);
		Assert.assertNotNull(personName);
		Assert.assertNotNull(city);

	}

	@Test
	public void getEmployeeByIdTest() {
		int personId = 23;
		Optional<Employee> p = Optional.of(new Employee());
		Mockito.when(empService.getEmployeeById(personId)).thenReturn(p);
		Assert.assertNotNull(empController.getEmployeeById(personId));
	}
}
