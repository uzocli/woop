package com.exatun.woop.activities.usermgt;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.exatun.woop.R;
import com.exatun.woop.activities.ABaseActivity;
import com.exatun.woop.database.dao.UserDao;
import com.exatun.woop.model.json.user.User;
import com.exatun.woop.model.json.user.UserAuthResult;
import com.exatun.woop.request.AuthRequest;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class ALogin extends ABaseActivity implements OnClickListener{

	private AuthRequest authRequest;
	private String email;
	private String password;
	private UserDao dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alogin);
	    findViewById(R.id.btn_act_login).setOnClickListener(this); 
	    findViewById(R.id.btn_gt_register).setOnClickListener(this); 
	}
	
	/**
	 * 
	 */
	private void doLogin(){

		email = ((EditText)findViewById(R.id.edt_login_email)).getText().toString();
		password = ((EditText)findViewById(R.id.edt_login_password)).getText().toString();
		
	    authRequest = new AuthRequest(email, password);
        setProgressBarIndeterminate( false );
        setProgressBarVisibility( true );

        getSpiceManager().execute( authRequest, "json", DurationInMillis.ALWAYS_EXPIRED, new AuthRequestListener() );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alogin, menu);
		return true;
	}

	public final class AuthRequestListener implements RequestListener<UserAuthResult>{

		@Override
		public void onRequestFailure(SpiceException spiceException) {
			// TODO Auto-generated method stub
			Toast.makeText(ALogin.this, "Login failure", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onRequestSuccess(UserAuthResult result) {
			// TODO Auto-generated method stub
			if(null != result && null != result.getUser()){
				Toast.makeText( ALogin.this, "Login success", Toast.LENGTH_SHORT ).show();
				User user = result.getUser();
				dao = new UserDao(ALogin.this);
				dao.open();
				dao.createUser(user);
				User user_ = dao.getUser();
				dao.close();
				if(null != user_){
					Toast.makeText(ALogin.this, "User "+ user.getFirstname()+" retrieved.", Toast.LENGTH_SHORT).show();
				}
			} else {
				Toast.makeText(ALogin.this, "Login failure 001", Toast.LENGTH_SHORT).show();
			}
		}
		
	}
	
	@Override
	protected void onResume() {
	  if( null != dao)
	    dao.open();
	    super.onResume();
	}

	@Override
	protected void onPause() {
      if( null != dao)
		dao.close();
	  super.onPause();
	}

	
	private void goToRegistrationPage(){
		Intent intent = new Intent(ALogin.this, ARegistration.class);
		startActivity(intent);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_act_login:
			doLogin();
			break;
			
		case R.id.btn_gt_register:
			goToRegistrationPage();
			break;

		default:
			break;
		}
	}

}
