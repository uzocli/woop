package com.exatun.woop.activities;


import com.octo.android.robospice.JacksonGoogleHttpClientSpiceService;
import com.octo.android.robospice.SpiceManager;

import android.support.v7.app.ActionBarActivity;

public class ABaseActivity extends ActionBarActivity {

	private SpiceManager spiceManager = new SpiceManager(JacksonGoogleHttpClientSpiceService.class);
	@Override
	protected void onStart() {
	  spiceManager.start(this);
	  super.onStart();
	}
	
	@Override
	protected void onStop() {
	  spiceManager.shouldStop();
	  super.onStop();
	}
	
	protected SpiceManager getSpiceManager() {
	  return spiceManager;
	}
}
