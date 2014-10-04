package com.chat.dao;

import com.chat.model.User;

public interface IUserDao {

	public User save(User user);
	public User getUser(int userId);

}
