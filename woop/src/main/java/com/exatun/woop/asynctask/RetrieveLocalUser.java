package com.exatun.woop.asynctask;

import com.exatun.woop.database.dao.UserDao;
import com.exatun.woop.model.json.user.User;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

class RetrieveLocalUser extends AsyncTask<Context, Integer, User>{
	private Context ctx;
	
	protected void onPreExecute(Context... params){
		super.onPreExecute();
		ctx = params[0];
		Toast.makeText(params[0], "Retrieving user", Toast.LENGTH_SHORT).show();
	}

	
	@Override
	protected User doInBackground(Context... params) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao(params[0]);
		User user = dao.getUser();
		
		return user;
	}
	
	@Override
	protected void onPostExecute(User result){
		super.onPostExecute(result);
		if(null != result)
			Toast.makeText(ctx, "Retrieve successful", Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(ctx, "No user to retrieve", Toast.LENGTH_SHORT).show();
	}

}
