package com.exatun.woop.model.json;

import com.google.api.client.util.Key;

public class ErrorMessage {

	@Key
	private int number;
	
	@Key
	private String type;

	@Key
	private String message;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@Override
	public String toString(){
		String str = "";
		str += message + " " + number;
		//str += "numbser:"+number+"#type:"+type+"#message:"+message;
		return str;		
	}
	
}
