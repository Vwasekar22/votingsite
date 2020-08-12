package com.app.dao;

import java.util.List;

import com.app.pojos.Candidate;

public interface ICandidateDao {

	List<Candidate> getCandidateList();
	
	String incVotes(int cId);
}
