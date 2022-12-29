package employee.details.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import employee.details.entity.Department;
import employee.details.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DepartmentControllerTest {

	
	@Autowired
	private DepartmentController deptController;

	@Mock
	private RequestAttributes attribute;

	@Mock
	private DepartmentService deptService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		RequestContextHolder.setRequestAttributes(attribute);
		this.mockMvc = MockMvcBuilders.standaloneSetup(deptController).build();
	}

	@Test
	public void getAllDepartment() {
		int id = 23;
		String Name = "IT";
		List<Department> p = new ArrayList<>();
		Mockito.when(deptService.getAllDepartment()).thenReturn(p);
		Assert.assertNotNull(deptController.getAllDepartment());
		Assert.assertNotNull(p);
		Assert.assertNotNull(id);
		Assert.assertNotNull(Name);

	}

	@Test
	public void  getDepartmentById() {
		int Id = 23;
		Optional<Department> p = Optional.of(new Department());
		Mockito.when(deptService.getDepartmentById(Id)).thenReturn(p);
		Assert.assertNotNull(deptController.getDepartmentById(Id));
	}
	
	@Test
	public void updateDepartment() {
		int id = 23;
		Department dep = new Department();
		dep.setId(id);
		dep.setName("IT");
		deptService.updateDepartment("23", dep);
		Mockito.doNothing().when(deptService).updateDepartment(anyString(),any());
		
		
	}
	}


