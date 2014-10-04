package com.chat.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.model.ChatRoom;
import com.chat.model.User;
import com.chat.model.UserChatRoom;
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
@Transactional
public class ChatRoomDao implements IChatRoomDao{
	@Autowired private SessionFactory sessionFactory;
	 
	   
	@Override
	public ChatRoom createChatRoom(ChatRoom chatRoom) {
		Session session=this.sessionFactory.getCurrentSession();
	    session.save(chatRoom);
	    return chatRoom;
	}


	@Override
	public UserChatRoom joinChatRoom(UserChatRoom userChatRoom) {
		Session session=this.sessionFactory.getCurrentSession();
	    session.save(userChatRoom);
	    return userChatRoom;
	}
	
	
	@Override
	public ChatRoom getChatRoom(int chatRoomId) {
		    
	    Session session=this.sessionFactory.getCurrentSession();
	    Criteria criteria=session.createCriteria(ChatRoom.class).add(Restrictions.eq("chatRoomId", chatRoomId));
	    Object result =  criteria.uniqueResult();
	    if(result !=null)
	    	return (ChatRoom)result;
	    else
	    return null;
		}


}
