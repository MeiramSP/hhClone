package kz.saparov.hhclone.service;

import java.util.List;

import kz.saparov.hhclone.dto.reply.ReplyRequest;
import kz.saparov.hhclone.dto.reply.ReplyResponse;

public interface ReplyService {
	
	public int save(ReplyRequest request, Long userId);
	
	public List<ReplyResponse> findByUserId(Long userId);

}
