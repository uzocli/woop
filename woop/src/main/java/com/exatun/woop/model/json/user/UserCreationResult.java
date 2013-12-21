package com.exatun.woop.model.json.user;


import com.exatun.woop.model.json.RequestResult;
import com.google.api.client.util.Key;

public class UserCreationResult extends RequestResult{

	@Key
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	
	public boolean equals(Object obj){
		if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        UserCreationResult other = (UserCreationResult)obj;
        if(status != other.status)
        	return false;
        
        return true;
	}
	
	@Override
	public String toString(){
		String str = "";
		if(null != user)
			str = user.toString();
		
		str += super.toString();		
		
		return str;
		
	}
	
}
