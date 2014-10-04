package com.chat.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.model.Message;
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
@Transactional
public class MessageDao implements IMessageDao{
	@Autowired private SessionFactory sessionFactory;
	 
	   
	@Override
	public void postMessage(Message message) {
		Session session=this.sessionFactory.getCurrentSession();
	    session.save(message);
	}

}
