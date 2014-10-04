package com.chat.model;



import java.io.Serializable;

import javax.persistence.*;

/**
 * Model class for Message
 */
@Entity
@Table(name = "CHATROOM")

public class ChatRoom implements Serializable {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="CHATROOMID")  
	private int chatRoomId;
	 @Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "CREATEDDATE", length = 100 )
	private String createdDate;
	
	

	
	@Override
    public String toString(){
        return "id="+ "name="+name;
    }
	public ChatRoom() {
	}

	 public ChatRoom(int chatRoomId, String message, String createdDate) {
			super();
			this.chatRoomId = chatRoomId;
			this.name = message;
			this.createdDate = createdDate;
		}



	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public int getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
