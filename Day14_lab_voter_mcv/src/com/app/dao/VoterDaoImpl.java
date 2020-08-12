package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Voter;

@Repository
public class VoterDaoImpl implements IVoterDao {

	@Autowired	//byType
	private SessionFactory sf;
	
	@Override
	public Voter authenticateVoter(String email, String pass) {
		String jpql = "select v from Voter v where v.email=:em and v.password=:ps";
		return sf.getCurrentSession().
				createQuery(jpql, Voter.class).
				setParameter("em", email).
				setParameter("ps", pass).
				getSingleResult();
	}

	@Override
	public String updateStatus(int vId) {
		Voter v = sf.getCurrentSession().get(Voter.class, vId);
		if(v!=null)
		{
			v.setStatus(!v.isStatus());
			return "Voter Status updated!!"; 
		}
		return null;
	}

}
