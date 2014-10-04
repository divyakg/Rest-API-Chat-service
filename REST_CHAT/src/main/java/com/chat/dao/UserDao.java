package com.chat.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.model.User;
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
@Transactional
public class UserDao implements IUserDao{
	@Autowired private SessionFactory sessionFactory;
	 
   
   
	public User save(User user){ 
	
    Session session=this.sessionFactory.getCurrentSession();
    session.save(user);
    return user;
	}
	
	public User getUser(int userId){ 
		
	    Session session=this.sessionFactory.getCurrentSession();
	    Criteria criteria=session.createCriteria(User.class).add(Restrictions.eq("userId", userId));
	    Object result =  criteria.uniqueResult();
	    if(result !=null)
	    	return (User)result;
	    else
	    return null;
		}

}
