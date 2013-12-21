package com.exatun.woop.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.exatun.woop.R;
import com.exatun.woop.activities.usermgt.ALogin;
import com.exatun.woop.database.dao.UserDao;
import com.exatun.woop.model.json.user.User;

public class AWoopActivity extends ABaseActivity implements OnClickListener{

	public final static String EXTRA_MSG_SEARCH_QUERY = "com.exatun.woop.SEARCH_QUERY";
	private EditText edit;
	private User user;
	
    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      requestWindowFeature( Window.FEATURE_PROGRESS );
      setContentView(R.layout.activity_main);
      
      // Retrieve the app owner in database
      new RetrieveLocalUser().execute();
      findViewById(R.id.btn_gt_login).setVisibility(View.INVISIBLE);
      findViewById(R.id.btn_gt_login).setOnClickListener(this);
      // edit = (EditText)findViewById(R.id.edt_login_email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// Inflate the menu; this adds items to the action bar if it is present.
    	getMenuInflater().inflate(R.menu.woop_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_gt_login:
			goToLoginPage();
			break;
		default:
			break;
		}
	}
	
	public void updateLayout(boolean show){
		if(show){
			findViewById(R.id.btn_gt_login).setVisibility(View.VISIBLE);
		} else {
			
		}
	}
	

	private void goToLoginPage(){
		Intent intent = new Intent(AWoopActivity.this, ALogin.class);
		startActivity(intent);
	}


	private void goToUserHomePage(){
		Intent intent = new Intent(AWoopActivity.this, AHome.class);
		startActivity(intent);
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.action_settings:
			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}	

	/* Async Task to retrieve saved user */
	private class RetrieveLocalUser extends AsyncTask<Void, Integer, User>{
		private Context ctx;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			Toast.makeText(AWoopActivity.this, "Retrieving user", Toast.LENGTH_SHORT).show();
		}
				
		@Override
		protected User doInBackground(Void... params) {
			// TODO Auto-generated method stub
			UserDao dao = new UserDao(AWoopActivity.this);
			dao.open();
			user = dao.getUser();
			dao.close();
			return user;
		}
		
		@Override
		protected void onPostExecute(User result){
			super.onPostExecute(result);
			if(null != result){
				Toast.makeText(getApplicationContext(), "Retrieve successful", Toast.LENGTH_SHORT).show();
				goToUserHomePage();
			} else {
				Toast.makeText(getApplicationContext(), "No user to retrieve", Toast.LENGTH_SHORT).show();
				//goToLoginPage();
				updateLayout(true);
			}
		}

	}
}

