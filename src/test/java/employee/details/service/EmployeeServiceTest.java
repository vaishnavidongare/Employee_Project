package employee.details.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import employee.details.repository.EmployeeRepo;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	@Mock
    private EmployeeRepo empRepo;


    private EmployeeService empService;

    @BeforeEach
    void setUp() {
        this.empService = new EmployeeService(this.empRepo);
    }

    @Test
    void getAllEmp() {
        empService.getAllEmployee();
        verify(empRepo).findAll();
    }
    
}
