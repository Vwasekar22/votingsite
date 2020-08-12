package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICandidateDao;
import com.app.pojos.Candidate;

@Service
@Transactional
public class CandidateServiceImpl implements ICandidateService {

	@Autowired
	private ICandidateDao dao;
	
	@Override
	public List<Candidate> getCandidateList() {
		
		return dao.getCandidateList();
	}

	@Override
	public String incVotes(int cId) {
		return dao.incVotes(cId);
	}

}
