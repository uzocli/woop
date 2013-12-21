package com.exatun.woop.model.json;

import java.util.ArrayList;

import com.google.api.client.util.Key;

public class RequestResult {

	@Key
	protected ArrayList<ErrorMessage> messages;

	/* Status of the wbs response: tell if there is error or not */
	@Key
	protected String status;

	public ArrayList<ErrorMessage> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<ErrorMessage> messages) {
		this.messages = messages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
		String str = "";
		
		str += "Status:"+status+"#messages:[";
		for(ErrorMessage msg : messages){
			str += msg.toString()+",";
		}
		str += "]";
		return str;		
	}
	
	
}
