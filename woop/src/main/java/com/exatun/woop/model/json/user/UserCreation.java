package com.exatun.woop.model.json.user;

import com.google.api.client.util.Key;

public class UserCreation {
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
	private String accept_policy;

	public UserCreation(){
		
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
	public String getAccept_policy() {
		return accept_policy;
	}
	public void setAccept_policy(String accept_policy) {
		this.accept_policy = accept_policy;
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
        
        return true;
	}
	
	
}
