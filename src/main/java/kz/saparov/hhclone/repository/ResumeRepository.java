package kz.saparov.hhclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kz.saparov.hhclone.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
	
	@Query(value = "SELECT r FROM Resume r JOIN User u on r.user.id = u.id WHERE u.id = ?1")
	public List<Resume> findByUserId(Long id); 

}
