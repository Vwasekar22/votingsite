package com.app.service;

import java.util.List;

import com.app.pojos.Candidate;

public interface ICandidateService {

	List<Candidate> getCandidateList();
	String incVotes(int cId);
}
