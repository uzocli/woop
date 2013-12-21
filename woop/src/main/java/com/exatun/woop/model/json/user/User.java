package com.exatun.woop.model.json.user;

import java.lang.reflect.Field;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Key;

public class User {
	@Key
	private long id;	//  int 11 not_null primary_key auto_increment
	@Key
	private String authentication_token;	//  int 11 not_null primary_key auto_increment
	@Key
	private String email;	//  string 300 not_null unique_key
	@Key
	private String password;	//  string 96 not_null
	@Key
	private String title;	//  string 3 
	@Key
	private String firstname;	//  string 300 not_null
	@Key
	private String lastname;	//  string 300 not_null
	@Key
	private String nickname;	//  string 75 unique_key
	@Key
	private String gender;	//  string 12 not_null enum
	@Key
	private String phone;	//  string 90 
	@Key
	private String address1;	//  string 300 
	@Key
	private String address2;	//  string 300 
	@Key
	private String zipcode;	//  string 15 
	@Key
	private String city;	//  string 300 
	@Key
	private String country;	//  string 6 multiple_key
	@Key
	private String birthdate;	//  date 10 binary
	@Key
	private String language;	//  string 6 multiple_key
	@Key
	private String interested_in;	//  string 60 
	@Key
	private String sexual_orientation;	//  string 3 
	@Key
	private String accept_policy;	//  int 1 
	@Key
	private String connexion_count;	//  int 11 
	@Key
	private String creation_date;
	@Key
	private String modification_date;
	@Key
	private String jid;
	
	public User(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthentication_token() {
		return authentication_token;
	}
	public void setAuthentication_token(String auth_token) {
		this.authentication_token = auth_token;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getInterested_in() {
		return interested_in;
	}
	public void setInterested_in(String interested_in) {
		this.interested_in = interested_in;
	}
	public String getSexual_orientation() {
		return sexual_orientation;
	}
	public void setSexual_orientation(String sexual_orientation) {
		this.sexual_orientation = sexual_orientation;
	}
	public String getAccept_policy() {
		return accept_policy;
	}
	public void setAccept_policy(String accept_policy) {
		this.accept_policy = accept_policy;
	}
	public String getConnexion_count() {
		return connexion_count;
	}
	public void setConnexion_count(String connexion_count) {
		this.connexion_count = connexion_count;
	}
	
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getModification_date() {
		return modification_date;
	}
	public void setModification_date(String modification_date) {
		this.modification_date = modification_date;
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
        User other = (User)obj;
        if(id != other.id)
        	return false;
        
        return true;
	}
	
	@Override
	public String toString(){
		String str = "";
		ClassInfo cInfo = ClassInfo.of(User.class);
		for(String fName : cInfo.getNames()){
			
		};
		for (Field field : this.getClass().getDeclaredFields()) {
	        //field.setAccessible(true); // if you want to modify private fields
			try {
				str += field.getName()
				         + " - " + field.getType()
				         + " - " + field.get(this);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		return str;
		
	}
	
	
}
