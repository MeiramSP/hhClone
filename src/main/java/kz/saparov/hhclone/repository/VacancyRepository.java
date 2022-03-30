package kz.saparov.hhclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kz.saparov.hhclone.entity.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long>{
	
	@Query(value = "SELECT v FROM Vacancy v JOIN FETCH v.company c")
	public List<Vacancy> findAll();
	
	@Query(value = "SELECT v FROM Vacancy v "
			+ "JOIN FETCH v.company c "
			+ "LEFT JOIN FETCH v.replyes r "
			+ "WHERE (r is NULL OR r.user.id = :id)")				
	public List<Vacancy> findWithUserReplyes(@Param("id") Long id);
	
}
