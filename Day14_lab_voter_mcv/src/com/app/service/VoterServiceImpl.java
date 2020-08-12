package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVoterDao;
import com.app.pojos.Voter;

@Service
@Transactional
public class VoterServiceImpl implements IVoterService {

	@Autowired
	private IVoterDao dao;
	
	@Override
	public Voter authenticateVoter(String email, String password) {
		
		return dao.authenticateVoter(email, password);
	}

	@Override
	public String updateStatus(int vId) {
		return dao.updateStatus(vId);
	}

}
