package com.app.pojos;
import javax.persistence.*;


@Entity
@Table(name = "voters")
public class Voter {

	private Integer id;
	private String email,password;
	private boolean status;
	private String role;
	
	public Voter() {
		super();
	}
	public Voter(Integer id, String email, String password, boolean status, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(unique = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Column(name = "admin_rights")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", email=" + email + ", status=" + status + ", role=" + role + "]";
	}
	
	
	
}
