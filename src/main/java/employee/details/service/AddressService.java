package employee.details.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.details.dto.AddressRequest;
import employee.details.entity.Address;
import employee.details.entity.Department;
import employee.details.entity.Employee;
import employee.details.repository.AddressRepo;
import employee.details.repository.EmployeeRepo;
@Service
public class AddressService {
	@Autowired
	   private EmployeeRepo emps;
	   @Autowired
	   private AddressRepo dprepo;
	   
	   public List<Address> getAllAddress(){
			
			List<Address> ad = new ArrayList<>();
			dprepo.findAll().forEach(ad::add);
			return ad;
		}
	public Address addAddress(AddressRequest adrs) {
		// TODO Auto-generated method stub
		Employee ep = emps.findById(adrs.emp_id);
		Address d = new Address();
        d.setCity(adrs.city);
        d.setCountry(adrs.country);
        d.setLine1(adrs.line1);
        d.setLine2(adrs.line2);
        d.setState(adrs.state);
        d.setType(adrs.type);
		d.setEmployee(ep);
		return dprepo.save(d);
	}
	public Address getAddressById(int id) {
		Address a = dprepo.findById(id);
		return a;
	}
	public Collection<Address> getEmpAddressById(int id) {
		List<Address> a = dprepo.GetEmpDetail(id);
		return a;
	}
	
	public void updateAddress(int emp_id, Address address) {
		
		String City=address.getCity();
		String Line1=address.getLine1();
		String Line2=address.getLine2();
		String State=address.getState();
		String Type=address.getType();
		String Country=address.getCountry();
		System.out.println(City);
		System.out.println(Line1);
		System.out.println(Line2);
		System.out.println(State);
		System.out.println(Type);
		System.out.println(Country);
		dprepo.saveEmpdetail(emp_id,City,Line1,Line2,State,Type,Country);
	}

	public void deleteAddress(int id) {
	    dprepo.deleteById(id);
	}
    public void deleteAllEmpAddress(int id) {
    	dprepo.deleteAllEmpAddress(id);
    }
}
