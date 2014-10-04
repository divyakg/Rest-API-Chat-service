package com.chat.model;



import java.io.Serializable;

import javax.persistence.*;


/**
 * Model class for Message
 */
@Entity
@Table(name = "USERCHATROOM")

public class UserChatRoom implements Serializable {
	
	
	@Column(name = "CREATEDDATE", length = 100 )
	private String createdDate;
	@EmbeddedId
	private UserChatRoomCompoundKey userChatRoomCk;
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public UserChatRoomCompoundKey getUserChatRoomCk() {
		return userChatRoomCk;
	}
	public void setUserChatRoomCk(UserChatRoomCompoundKey userChatRoomCk) {
		this.userChatRoomCk = userChatRoomCk;
	}
	

	
	
	

}
