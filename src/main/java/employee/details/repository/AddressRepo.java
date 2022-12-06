package employee.details.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import employee.details.entity.Address;

public interface AddressRepo extends CrudRepository<Address,Integer>{
	Address findById(int emp_id);

	@Query(value = "SELECT * FROM Address u WHERE u.emp_id = :id",nativeQuery = true)
	List<Address> GetEmpDetail(int id);

	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Address u SET u.city=:City,u.country=:Country,u.line1=:Line1,u.line2=:Line2,u.state=:State,u.type=:Type WHERE u.emp_id = :id",nativeQuery = true)
	void saveEmpdetail(int id,String City,String Country,String Line1,String Line2,String State,String Type);

	@Modifying
	@Transactional
	@Query(value="DELETE * FROM Address u WHERE u.emp_id = :id",nativeQuery = true)
	void deleteAllEmpAddress(int id);


}
