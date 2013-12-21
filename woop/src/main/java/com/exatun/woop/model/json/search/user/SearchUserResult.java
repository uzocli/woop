package com.exatun.woop.model.json.search.user;

import com.exatun.woop.model.json.user.User;
import com.google.api.client.util.Key;

public class SearchUserResult {

	@Key
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        SearchUserResult other = (SearchUserResult) obj;
        if ( user == null ) {
            if ( other.user != null ) {
                return false;
            }
        } else if ( !user.equals( other.user ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SearchUserResult [user=" + user + "]";
    }
	
}
