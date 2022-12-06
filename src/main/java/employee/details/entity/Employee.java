package employee.details.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="position")
	private String des;
	@Column(name="salary")
	private Long salary;    
	@ManyToOne()
	@JoinColumn(name = "dept_id",referencedColumnName = "id")
    Department department;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Address> ad = new ArrayList<>();
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer id, String name, String des, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.salary = salary;
	}
	
	public Integer getEid() {
		return id;
	}
	public void setEid(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Address> getAd() {
		return ad;
	}

	public void setAd(List<Address> ad) {
		this.ad = ad;
	}
	
}