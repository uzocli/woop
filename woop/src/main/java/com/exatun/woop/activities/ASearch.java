package com.exatun.woop.activities;

import com.exatun.woop.R;
import com.exatun.woop.R.id;
import com.exatun.woop.R.layout;
import com.exatun.woop.R.menu;
import com.exatun.woop.model.json.search.user.SearchUserResult;
import com.exatun.woop.request.SearchUserRequest;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class ASearch extends ABaseActivity {

	private String query;
	private TextView result;
	private SearchUserRequest searchUserRequest;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		// Show the Up button in the action bar.
		setupActionBar();
		//
		result = (TextView)findViewById(R.id.text_searchResult);
		Intent intent = getIntent();
		query = intent.getStringExtra(AWoopActivity.EXTRA_MSG_SEARCH_QUERY);
		
		searchUserRequest = new SearchUserRequest(query);
		
	}
	
	@Override
    protected void onStart() {
        super.onStart();

        setProgressBarIndeterminate( false );
        setProgressBarVisibility( true );

        getSpiceManager().execute( searchUserRequest, "json", DurationInMillis.ALWAYS_EXPIRED, new SearchUserRequestListener() );
    }

	public final class SearchUserRequestListener implements RequestListener< SearchUserResult >{

		@Override
		public void onRequestFailure(SpiceException arg0) {
			// TODO Auto-generated method stub
			Toast.makeText( ASearch.this, "failure", Toast.LENGTH_SHORT ).show();
		}

		@Override
		public void onRequestSuccess(final SearchUserResult result) {
			// TODO Auto-generated method stub
			 Toast.makeText( ASearch.this, "success", Toast.LENGTH_SHORT ).show();
	            ASearch.this.result.setText( null==result?"":result.getUser().toString() );
		}		
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.asearch, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	

}
