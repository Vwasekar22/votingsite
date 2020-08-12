package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {

	private Integer id;
	private String name,party;
	private int votes;
	
	public Candidate() {
		super();
	}

	public Candidate(Integer id, String name, String party, int votes) {
		super();
		this.id = id;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "political_party")
	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
	
}
