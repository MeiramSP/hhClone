package kz.saparov.hhclone.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.hhclone.dto.reply.ReplyRequest;
import kz.saparov.hhclone.dto.reply.ReplyResponse;
import kz.saparov.hhclone.repository.ReplyRepository;
import kz.saparov.hhclone.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Override
	public int save(ReplyRequest dto, Long userId) {
		return replyRepository.inserReply(dto.getMessage(),dto.getResumeId(),userId,dto.getVacancyId());
	}

	@Override
	public List<ReplyResponse> findByUserId(Long userId) {		
		return replyRepository.findByUserId(userId).stream()
				.map(ReplyResponse::convert)
				.collect(Collectors.toList());		
	}

}
