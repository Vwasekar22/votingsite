package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Candidate;

@Repository
public class CandidateDaoImpl implements ICandidateDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Candidate> getCandidateList() {
		String jpql = "select c from Candidate c";
		return sf.getCurrentSession().createQuery(jpql, Candidate.class).getResultList();
	}

	@Override
	public String incVotes(int cId) {
		Candidate c = sf.getCurrentSession().get(Candidate.class, cId);
		if(c!=null)
		{
			c.setVotes(c.getVotes()+1);
			return "Votes Updated Successfully!!";
		}
		return null;
	}

}
