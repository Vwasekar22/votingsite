package com.app.dao;

import com.app.pojos.Voter;

public interface IVoterDao {

	Voter authenticateVoter(String email,String pass);
	String updateStatus(int vId);
}
