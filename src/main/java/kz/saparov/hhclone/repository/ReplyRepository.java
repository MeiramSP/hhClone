package kz.saparov.hhclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kz.saparov.hhclone.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	@Query(value = "SELECT r FROM Reply r WHERE r.user.id = ?1")
	public List<Reply> findByUserId(Long userId);

}
