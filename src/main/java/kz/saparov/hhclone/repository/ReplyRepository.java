package kz.saparov.hhclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kz.saparov.hhclone.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "insert into replyes(message, resume_id, user_id, vacancy_id) values(?, ?, ?, ?)",
		   nativeQuery = true)
	public int inserReply(String message, Long resumeId, Long userId, Long vacancyId);
	
	@Query("SELECT r FROM Reply r JOIN FETCH r.vacancy v "
			                   + "JOIN r.user u WHERE u.id = :id")
	public List<Reply> findByUserId(@Param("id") Long id);

}
