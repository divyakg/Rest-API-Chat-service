package com.chat.model;



import java.io.Serializable;

import javax.persistence.*;

/**
 * Model class for Message
 */
@Entity
@Table(name = "MESSAGE")

public class Message implements Serializable {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="MESSAGEID")  
	private int messageId;
	 @Column(name = "MESSAGE", length = 100)
	private String message;
	@Column(name = "CREATEDDATE", length = 100 )
	private String createdDate;
	
	private ChatRoom chatRoom;
	

	
	@Override
    public String toString(){
        return "id="+messageId+", name="+message;
    }
	public Message() {
	}

	 public Message(int messageId, String message, String createdDate) {
			super();
			this.messageId = messageId;
			this.message = message;
			this.createdDate = createdDate;
		}



	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CHATROOMID")
	 public ChatRoom getChatRoom() {
		return chatRoom;
	}
	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}
	
	

}
