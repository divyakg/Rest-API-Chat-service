package com.chat.controller;




import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.chat.util.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chat.dao.IUserDao;
import com.chat.model.User;

@RestController
@RequestMapping(value="/user", params = { "name", "email","password" })
public class UserController {
	@Autowired private IUserDao userDao;
	   
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	 @RequestMapping( ApplicationConstants.CREATE_USR)
	 @ResponseBody
	    public  Object createUser(@RequestParam("name") String name,
	    		@RequestParam("email") String email,
	    		@RequestParam("password") String password) {
	    	User user=new User();
	    	Map<Object,String> errorMap=new HashMap<Object, String>(); 
	    	if(name==null || "".equals(name)){
	    		errorMap.put(1, "Please enter name");
	    	}
	    	if(email==null || "".equals(email)){
	    		errorMap.put(2, "Please enter email");
	    	}
	    	if(password==null || "".equals(password)){
	    		errorMap.put(3, "Please enter password");
	    	}
	    	if (errorMap.size()>0){
	    		return errorMap;
	    	}else{
		    	user.setName(name);
		    	user.setEmail(email);
		    	user.setPassword(password);
		    	user.setCreatedDate(new Date().toString());
		    	user.setStatus(ApplicationConstants.STATUS_ACTIVE);
		    	userDao.save(user);
		        return user;
	    	}
	    }

	
	
	
	  
	 

}
