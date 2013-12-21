package com.exatun.woop.database;

import com.exatun.woop.database.contract.DbMainContract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DbHelper extends SQLiteOpenHelper {

	private String database_name;
	private int database_version;
	
	public DbHelper(Context context, String name, int version) {
		super(context, name, null, version);
		database_name = name;
		database_version = version;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DbMainContract.UserTable.SQL_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(DbHelper.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		// Delete all table
	    db.execSQL("DROP TABLE IF EXISTS " + DbMainContract.UserTable.TABLE_NAME);

	    // Recreate the DB
	    onCreate(db);
	}

}
