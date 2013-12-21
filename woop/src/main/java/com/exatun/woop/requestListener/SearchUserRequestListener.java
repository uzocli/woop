package com.exatun.woop.requestListener;

import android.content.Context;
import android.widget.Toast;

import com.exatun.woop.activities.AWoopActivity;
import com.exatun.woop.model.json.search.user.SearchUserResult;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class SearchUserRequestListener  implements RequestListener< SearchUserResult >{

	Context ctx;
	
	public SearchUserRequestListener(Context callerActivity){
		this.ctx = callerActivity;
	}
	
	@Override
	public void onRequestFailure(SpiceException arg0) {
		// TODO Auto-generated method stub
		Toast.makeText( ctx, "failure", Toast.LENGTH_SHORT ).show();
	}

	@Override
	public void onRequestSuccess(final SearchUserResult result) {
		// TODO Auto-generated method stub
		 Toast.makeText( ctx, "success", Toast.LENGTH_SHORT ).show();
		 /*if(this.ctx.getClass() == WoopActivity.class)
			 this.ctx.
            text.setText( result.getUser().toString() );*/
	}
	
}
