package employee.details.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Department")
public class Department {
  
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    private List<Employee> emp = new ArrayList<>();
	
	
	
	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(Integer id, String name, List<Employee> emp) {
		super();
		this.id = id;
		this.name = name;
		this.emp = emp;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
	
	
}