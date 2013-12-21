package com.exatun.woop.activities.usermgt;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.exatun.woop.R;
import com.exatun.woop.activities.ABaseActivity;
import com.exatun.woop.database.dao.UserDao;
import com.exatun.woop.model.json.ErrorMessage;
import com.exatun.woop.model.json.user.User;
import com.exatun.woop.model.json.user.UserCreation;
import com.exatun.woop.model.json.user.UserCreationResult;
import com.exatun.woop.request.RegistrationRequest;
import com.exatun.woop.utils.SpinnerObject;
import com.exatun.woop.utils.ViewUtils;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class ARegistration extends ABaseActivity {

	private RegistrationRequest registerReq;
	private UserCreation userData;
	private Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aregistration);
		
		//
		SpinnerObject gender1 = new SpinnerObject("M", "Man");
		SpinnerObject gender2 = new SpinnerObject("F", "Woman");
		ArrayList<SpinnerObject> list = new ArrayList<SpinnerObject>();
		list.add(gender1);
		list.add(gender2);
		Spinner genderSp = (Spinner)findViewById(R.id.spi_registration_gender);
		ArrayAdapter<SpinnerObject> adapter = new ArrayAdapter<SpinnerObject>(ARegistration.this, R.layout.support_simple_spinner_dropdown_item, list);
		genderSp.setAdapter(adapter);
		
		findViewById(R.id.btn_act_register).setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				doRegister();
			}
		});
	}
	
	private void buildData(){
		userData = new UserCreation();
		userData.setFirstname(ViewUtils.getViewText((TextView)findViewById(R.id.edt_registration_firstname)));
		userData.setLastname(ViewUtils.getViewText((TextView)findViewById(R.id.edt_registration_lastname)));
		userData.setNickname(ViewUtils.getViewText((TextView)findViewById(R.id.edt_registration_nickname)));
		userData.setEmail(ViewUtils.getViewText((TextView)findViewById(R.id.edt_registration_email)));
		userData.setPassword(ViewUtils.getViewText((TextView)findViewById(R.id.edt_registration_password)));
		Spinner genderSp = (Spinner)findViewById(R.id.spi_registration_gender);
		userData.setGender( ((SpinnerObject)genderSp.getSelectedItem()).getId() );
		userData.setLanguage("EN");
		//genderSp.getSelectedItemId();
	}
	
	private void doRegister(){

		String password_conf = ViewUtils.getViewText((TextView)findViewById(R.id.edt_registration_password_conf));
		
		buildData();
		if(null == userData.getEmail() || userData.getEmail().equals("")){
			Builder dia = new AlertDialog.Builder(ARegistration.this);
			dia.setTitle("Ooops");
			dia.setMessage("E-mail empty");
			dia.setNeutralButton("Ok", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					});
			dia.show();
		} else if(null == userData.getPassword() || userData.getPassword().equalsIgnoreCase("")){
			Builder dia = new AlertDialog.Builder(ARegistration.this);
			dia.setTitle("Ooops");
			dia.setMessage("Passwords empty");
			dia.setNeutralButton("Ok", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					});
			dia.show();
		} else if(null != userData.getPassword() && !userData.getPassword().equalsIgnoreCase(password_conf)){
			Builder dia = new AlertDialog.Builder(ARegistration.this);
			dia.setTitle("Ooops");
			dia.setMessage("Passwords don't match");
			dia.setNeutralButton("Ok", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					});
			dia.show();
		} else {
			registerReq = new RegistrationRequest(userData);
	
	        setProgressBarIndeterminate( false );
	        setProgressBarVisibility( true );
	        //ctx = ARegistration.this;
	        getSpiceManager().execute( registerReq, "json", DurationInMillis.ALWAYS_EXPIRED, new RegisterRequestListener() );
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aregistration, menu);
		return true;
	}

	
	private class RegisterRequestListener implements RequestListener<UserCreationResult>{

		@Override
		public void onRequestFailure(SpiceException spiceException) {
			// TODO Auto-generated method stub
			Toast.makeText(ARegistration.this, "Registration failure", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onRequestSuccess(UserCreationResult result) {
			// TODO Auto-generated method stub
			Toast.makeText( ARegistration.this, null==result?"":result.toString(), Toast.LENGTH_SHORT ).show();
			if(null != result && null != result.getUser()){
				Toast.makeText( ARegistration.this, "Registration success", Toast.LENGTH_SHORT ).show();
				User user = result.getUser();
				UserDao dao = new UserDao(ARegistration.this);
				dao.open();
				dao.createUser(user);
				dao.close();
			} else if(null != result) {
				List<ErrorMessage> errors = result.getMessages();
				if(errors.size() > 0){
					Toast.makeText(ARegistration.this, errors.get(0).toString() + " ", Toast.LENGTH_LONG).show();
				}				
			} else {
				Toast.makeText(ARegistration.this, "Registration failure 001", Toast.LENGTH_SHORT).show();
			}
		}
		
	}
}
