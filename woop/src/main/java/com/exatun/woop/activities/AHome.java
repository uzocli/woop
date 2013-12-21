package com.exatun.woop.activities;

import com.exatun.woop.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class AHome extends ABaseActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ahome);
	    //findViewById(R.id.btn_gt_search).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ahome, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	private void goToSearchPage(){
		Intent intent = new Intent(AHome.this, ASearch.class);
		intent.putExtra(AWoopActivity.EXTRA_MSG_SEARCH_QUERY, "test");
		startActivity(intent);
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
//		switch (v.getId()) {
//			case R.id.btn_gt_search:
//				goToSearchPage();
//				break;
//	
//			default:
//				break;
//		}
	}

}
