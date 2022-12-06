package employee.details.dto;

import javax.persistence.Column;

public class AddressRequest {
	public int id;
	public String type;
	public String line1;
	public String line2;
	public String city;
	public String state;
	public String country;
	public int emp_id;
}
