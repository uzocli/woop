package com.exatun.woop.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.exatun.woop.database.DbHelper;
import com.exatun.woop.database.contract.DbMainContract;
import com.exatun.woop.model.json.user.User;

public class UserDao {
	
  private SQLiteDatabase database;
  private DbHelper dbHelper;
  private String[] allColumns = { DbMainContract.UserTable.COLUMN_NAME_ID, DbMainContract.UserTable.COLUMN_NAME_EMAIL,
		  DbMainContract.UserTable.COLUMN_NAME_FIRSTNAME, DbMainContract.UserTable.COLUMN_NAME_LASTNAME,
		  DbMainContract.UserTable.COLUMN_NAME_NICKNAME, DbMainContract.UserTable.COLUMN_NAME_GENDER,
		  DbMainContract.UserTable.COLUMN_NAME_LAST_UPDATE, DbMainContract.UserTable.COLUMN_NAME_AUTH_TOKEN};

  public UserDao(Context context) {
    dbHelper = new DbHelper(context, DbMainContract.DATABASE_NAME, DbMainContract.DATABASE_VERSION);
  }

  public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

  public void close() {
    dbHelper.close();
  }
  
  public User createUser(User nUser) {
	ContentValues values = new ContentValues();
    values.put(DbMainContract.UserTable.COLUMN_NAME_EMAIL, nUser.getEmail());
    values.put(DbMainContract.UserTable.COLUMN_NAME_FIRSTNAME, nUser.getFirstname());
    values.put(DbMainContract.UserTable.COLUMN_NAME_LASTNAME, nUser.getLastname());
    values.put(DbMainContract.UserTable.COLUMN_NAME_NICKNAME, nUser.getNickname());
    values.put(DbMainContract.UserTable.COLUMN_NAME_GENDER, nUser.getGender());
    values.put(DbMainContract.UserTable.COLUMN_NAME_AUTH_TOKEN, nUser.getGender());
    long insertId = database.insert(DbMainContract.UserTable.TABLE_NAME, null,
        values);
    Cursor cursor = database.query(DbMainContract.UserTable.TABLE_NAME,
        allColumns, DbMainContract.UserTable.COLUMN_NAME_ID + " = " + insertId, null, null, null, null);
	
	User newUser = cursorToUser(cursor);
	cursor.close();
	return newUser;
  }
  
  public User getUserWithToken(String token){
	Cursor c = database.query(DbMainContract.UserTable.TABLE_NAME, allColumns, 
			DbMainContract.UserTable.COLUMN_NAME_AUTH_TOKEN + " LIKE \"" + token +"\"", null, null, null, null);
	return cursorToUser(c);
  }
  
  /**
   * Retrieve the last inserted user
   * @return
   */
  public User getUser(){
	Cursor c = database.query(DbMainContract.UserTable.TABLE_NAME, allColumns, 
			null , null, null, null, DbMainContract.UserTable.COLUMN_NAME_ID + " DESC");
	return cursorToUser(c);
  }
  
  public void deleteUser(User user) {
	String email = user.getEmail();
	System.out.println("Comment deleted with id: " + email);
	database.delete(DbMainContract.UserTable.TABLE_NAME, DbMainContract.UserTable.COLUMN_NAME_EMAIL
	      + " LIKE " + email, null);
  }
  
  private User cursorToUser(Cursor cursor) {
	if(null == cursor || cursor.getCount() == 0)
	  return null;
	
	cursor.moveToFirst();
	
	User user = new User();
	user.setId(cursor.getLong(0));
	user.setEmail(cursor.getString(1));
	user.setFirstname(cursor.getString(2));
	user.setLastname(cursor.getString(3));
	user.setNickname(cursor.getString(4));
	user.setGender(cursor.getString(5));
	user.setAuthentication_token(cursor.getString(7));
	//user.setGender(cursor.getString(6));
	
	return user;
  }
}
