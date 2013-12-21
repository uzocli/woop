package com.exatun.woop.utils;

public class SpinnerObject {

	private String itemId;
	private String itemValue;
	
	public SpinnerObject ( String itemId , String itemValue ) {
	    this.itemId = itemId;
	    this.itemValue = itemValue;
	}
	
	public String getId () {
	    return itemId;
	}
	
	public String getValue () {
	    return itemValue;
	}
	
	@Override
	public String toString () {
	    return itemValue;
	}
}
