package kz.saparov.hhclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.hhclone.model.ReplyModel;
import kz.saparov.hhclone.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Override
	public int save(ReplyModel model, Long userId) {
		
		return replyRepository.inserReply(model.getMessage(), 
										  model.getResumeId(),
										  userId, 
										  model.getVacancyId());
	}

}
