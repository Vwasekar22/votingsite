package com.app.service;

import com.app.pojos.Voter;

public interface IVoterService {

	Voter authenticateVoter(String email,String password);
	String updateStatus(int vId);
}
