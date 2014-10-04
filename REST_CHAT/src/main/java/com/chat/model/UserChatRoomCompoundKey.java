package com.chat.model;



import java.io.Serializable;

import javax.persistence.*;


/**
 */
@Embeddable

public class UserChatRoomCompoundKey implements Serializable {
	
	private int chatRoomId;
	private int userId;
	
	public UserChatRoomCompoundKey(int chatRoomId, int userId) {
		super();
		this.chatRoomId = chatRoomId;
		this.userId = userId;
	}
	public UserChatRoomCompoundKey() {
		super();
	}
	
	public int getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
