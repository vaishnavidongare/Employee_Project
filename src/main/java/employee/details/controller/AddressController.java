package employee.details.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.details.dto.AddressRequest;
import employee.details.entity.Address;
import employee.details.entity.Department;
import employee.details.entity.Employee;
import employee.details.service.AddressService;
import employee.details.service.EmployeeService;

@RestController
@RequestMapping(value="/api/address")
public class AddressController {
	 @Autowired
     private AddressService ads;
	 
	 //To add Address of Employee
	 @PostMapping
		public Address addAddress(@RequestBody AddressRequest adrs ) {
			
			return ads.addAddress(adrs);
		}
	 //To get All Addresses
	 @GetMapping
	 public List<Address> getAllAddress(){
			
			return ads.getAllAddress();
			
		}

	 //To get Address By Id
	 @GetMapping("/{id}")
		public Address getAddressById(@PathVariable ("id")  int id) {
		 return  this.ads.getAddressById(id);
		}
	 //Retrieve all address of employee by emp_id
	 @GetMapping("/emp/{emp_id}")
		public Collection<Address> getEmpAddressById(@PathVariable ("emp_id")  int emp_id) {
		 return  this.ads.getEmpAddressById(emp_id);
		}
	 
	 //To Update address of employee by emp_id
	 @PutMapping("/{emp_id}")
	    public void updateAddress(@PathVariable ("emp_id") int emp_id,  @RequestBody Address address) {
		 ads.updateAddress(emp_id,address);
		}
	 
	 //To Delete Address by Id
	 @DeleteMapping("/{id}")
	 public void deleteAddress(@PathVariable ("id") int id) {
	     ads.deleteAddress(id);
	 }
	//Delete all Address of an employee
	 @DeleteMapping("/emp/{emp_id}")
	 public void deleteAllEmpAddress(@PathVariable ("emp_id") int id) {
	     ads.deleteAddress(id);
	 }
	 
}
