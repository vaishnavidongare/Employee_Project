package employee.details.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import employee.details.entity.Address;
import employee.details.service.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AddressControllerTest {

	@Autowired
	private AddressController adrController;

	@Mock
	private RequestAttributes attribute;

	@Mock
	private AddressService adService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		RequestContextHolder.setRequestAttributes(attribute);
		this.mockMvc = MockMvcBuilders.standaloneSetup(adrController).build();
	}

	
	@Test
	public void getAllAddress() {
		int Id = 23;
		String type = "Home";
		String city = "Pune";
		List<Address> p = new ArrayList<>();
		Mockito.when(adService.getAllAddress()).thenReturn(p);
		Assert.assertNotNull(adrController.getAllAddress());
		Assert.assertNotNull(Id);
		Assert.assertNotNull(type);
		Assert.assertNotNull(city);
	}

	@Test
	public void getPersonByIdTest() {
		int personId = 23;
		Address p = new Address();
		Mockito.when(adService.getAddressById(personId)).thenReturn(p);
		Assert.assertNotNull(adrController.getAddressById(personId));
	}

}
