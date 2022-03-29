package kz.saparov.hhclone.service;

import kz.saparov.hhclone.model.ReplyModel;

public interface ReplyService {
	
	public int save(ReplyModel model, Long userId);

}
