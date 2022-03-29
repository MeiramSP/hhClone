package kz.saparov.hhclone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kz.saparov.hhclone.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
	
	@Query(value = "SELECT c FROM Company c JOIN User u on c.id = u.company.id WHERE u.id = ?1")
	public Optional<Company> findByHrId(Long id); 

}
