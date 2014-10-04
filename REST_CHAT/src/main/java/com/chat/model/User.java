package com.chat.model;



import java.io.Serializable;

import javax.persistence.*;

/**
 * Model class for Conact
 */
@Entity
@Table(name = "USER")

public class User implements Serializable {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="USERID")  
	private int userId;
	 @Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "EMAIL", length = 100 )
	private String email;
	@Column(name = "PASSWORD", length = 100 )
	private String password;
	@Column(name = "STATUS", length = 100)
	private String status;
	@Column(name = "STATUSMESSAGE", length = 100)
	private String statusMessage;
	@Column(name = "CREATEDDATE", length = 100 )
	private String createdDate;

	
	@Override
    public String toString(){
        return "id="+userId+", name="+name;
    }
	public User() {
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
