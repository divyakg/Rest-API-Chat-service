package com.chat.dao;

import com.chat.model.ChatRoom;
import com.chat.model.UserChatRoom;


public interface IChatRoomDao {
	public ChatRoom createChatRoom(ChatRoom chatRoom);
	public UserChatRoom joinChatRoom(UserChatRoom userChatRoom);
	public ChatRoom getChatRoom(int chatRoomId);
}
