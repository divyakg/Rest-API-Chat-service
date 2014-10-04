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

import com.chat.dao.IChatRoomDao;
import com.chat.dao.IMessageDao;
import com.chat.dao.IUserDao;
import com.chat.model.ChatRoom;
import com.chat.model.Message;
import com.chat.model.User;

@RestController
@RequestMapping(value="/chat", params = { "message", "chatRoomId" })
public class MessageController {
	@Autowired private IMessageDao messageDao;
	@Autowired private IChatRoomDao chatRoomDao;
	   
	 private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	 @RequestMapping( ApplicationConstants.POST_CHAT)
	 @ResponseBody
	    public  Object postMessage(@RequestParam("message") String message,
	    		@RequestParam("chatRoomId") String chatRoomId) {
	    	Map<Object,String> errorMap=new HashMap<Object, String>(); 
	    	if(message==null || "".equals(message)){
	    		errorMap.put(1, "Please enter message");
	    	}
	    	if(chatRoomId==null || "".equals(chatRoomId)){
	    		errorMap.put(2, "Please enter chatRoomId");
	    	}
	    	
	    	if (errorMap.size()>0){
	    		return errorMap;
	    	}else{
	    		Message messageToSave=new Message();
	    		messageToSave.setMessage(message);
	    		ChatRoom chatRoom=chatRoomDao.getChatRoom(Integer.parseInt(chatRoomId));
	    		if(chatRoom==null){
	    			errorMap.put(3, "ChatRoom does not exist");
	    			return errorMap;
	    		}
	    		messageToSave.setChatRoom(chatRoom);
	    		messageToSave.setCreatedDate(new Date().toString());
		    	messageDao.postMessage(messageToSave);
		        return messageToSave;
	    	}
	    }

	
	
	
	  
	 

}
