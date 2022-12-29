

package employee.details.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import employee.details.entity.Address;
import employee.details.repository.AddressRepo;
import employee.details.repository.DepartmentRepo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
	@Mock
    private AddressRepo adRepo;


    private AddressService adService;

    @BeforeEach
    void setUp() {
        this.adService = new AddressService(this.adRepo);
    }

    @Test
    void getAllEmp() {
        adService.getAllAddress();
        verify(adRepo).findAll();
    }
    
    
    
}
