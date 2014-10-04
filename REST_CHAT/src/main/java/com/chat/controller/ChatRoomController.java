package com.chat.controller;




import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.chat.util.ApplicationConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chat.dao.IChatRoomDao;
import com.chat.dao.IUserDao;
import com.chat.model.ChatRoom;
import com.chat.model.User;
import com.chat.model.UserChatRoom;
import com.chat.model.UserChatRoomCompoundKey;

@RestController
@RequestMapping(value="/chat")
public class ChatRoomController {
	@Autowired private IChatRoomDao chatRoomDao;
	@Autowired private IUserDao userDao;
	   
	 private static final Logger logger = LoggerFactory.getLogger(ChatRoomController.class);
	 @RequestMapping( ApplicationConstants.CREATE_CHAT)
	 @ResponseBody
	    public  Object createChatRoom(@RequestParam("name") String name) {
	    	ChatRoom chatRoom=new ChatRoom();
	    	Map<Object,String> errorMap=new HashMap<Object, String>(); 
	    	System.out.println("name11111"+name);
	    	if(name==null || "".equals(name)){
	    		errorMap.put(1, "Please enter name");
	    	}
	    	
	    	if (errorMap.size()>0){
	    		return errorMap;
	    	}else{
	    		chatRoom.setName(name);
	    		chatRoom.setCreatedDate(new Date().toString());
		    	chatRoomDao.createChatRoom(chatRoom);
		        return chatRoom;
	    	}
	    }

	 @RequestMapping( ApplicationConstants.JOIN_CHAT)
	    public  Object joinChatRoom(@RequestParam("chatRoomId") String chatRoomId,
	    		@RequestParam("userId") String userId) {
	    	UserChatRoom chatRoom=new UserChatRoom();
	    	Map<Object,String> errorMap=new HashMap<Object, String>(); 
	    	System.out.println("name11111"+chatRoomId);
	    	if(chatRoomId==null || "".equals(chatRoomId)){
	    		errorMap.put(1, "Please enter chatRoomId");
	    	}
	    	if(userId==null || "".equals(userId)){
	    		errorMap.put(2, "Please enter userId");
	    	}
	    	
	    	if (errorMap.size()>0){
	    		return errorMap;
	    	}else{
	    		
	    		User userFromDb=userDao.getUser(Integer.parseInt(userId));
	    		ChatRoom chatRoomFromDb=chatRoomDao.getChatRoom(Integer.parseInt(chatRoomId));
	    		if(userFromDb==null){
	    			errorMap.put(3, "User does not exist");
	    			return errorMap;
	    		}
	    		else if(chatRoomFromDb==null){
	    		errorMap.put(4, "Chat Room does not exist");
	    			return errorMap;
	    			
	    		}else{
		    		UserChatRoomCompoundKey userChatRoom=new UserChatRoomCompoundKey();
		    		userChatRoom.setUserId(Integer.parseInt(userId));
		    		userChatRoom.setChatRoomId(Integer.parseInt(chatRoomId));
		    		chatRoom.setUserChatRoomCk(userChatRoom);
		    		chatRoom.setCreatedDate(new Date().toString());
			    	System.out.println("##########################");
			    	chatRoomDao.joinChatRoom(chatRoom);
			        return chatRoom;
	    		}
	    	}
	    }
	
	
	  
	 

}
