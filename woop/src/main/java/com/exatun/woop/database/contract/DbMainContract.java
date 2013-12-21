package com.exatun.woop.database.contract;

import android.provider.BaseColumns;

public final class DbMainContract {

	public DbMainContract(){		
	}
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	private static final String BOOLEAN_TYPE = " BOOLEAN";
	private static final String COMMA_SEP = ",";
	private static final String NOT_NULL = " NOT NULL";
	
	public static final String DATABASE_NAME = "users.db";
	public static final int DATABASE_VERSION = 1;
	
	public static abstract class UserTable implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_AUTH_TOKEN = "auth_token";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_FIRSTNAME = "firstname";
        public static final String COLUMN_NAME_LASTNAME = "lastname";
        public static final String COLUMN_NAME_NICKNAME = "nickname";
        public static final String COLUMN_NAME_GENDER = "gender";
        public static final String COLUMN_NAME_LAST_UPDATE = "lastupdate";
        
        public static final String SQL_CREATE =
        	    "CREATE TABLE " + UserTable.TABLE_NAME + " (" +
        	    		UserTable.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
        	    		UserTable.COLUMN_NAME_AUTH_TOKEN + TEXT_TYPE + COMMA_SEP +
        	    		UserTable.COLUMN_NAME_EMAIL + TEXT_TYPE + NOT_NULL + COMMA_SEP +
        	    		UserTable.COLUMN_NAME_FIRSTNAME + TEXT_TYPE + NOT_NULL + COMMA_SEP +
        	    		UserTable.COLUMN_NAME_LASTNAME + TEXT_TYPE + COMMA_SEP +
        	    		UserTable.COLUMN_NAME_NICKNAME + TEXT_TYPE + NOT_NULL + COMMA_SEP +
        	    		UserTable.COLUMN_NAME_GENDER + TEXT_TYPE + NOT_NULL + COMMA_SEP +
        	    		UserTable.COLUMN_NAME_LAST_UPDATE + TEXT_TYPE +         	    
        	    " )";
        
        private static final String SQL_DELETE_USER =
        	    "DROP TABLE IF EXISTS " + UserTable.TABLE_NAME;
        
    }
	
	/* Store locations typed by the user */
	public static abstract class LocationTable implements BaseColumns {
        public static final String TABLE_NAME = "location";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_FAVORITE = "is_favorite";
        
        
        
	}
}
