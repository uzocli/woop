package com.exatun.woop.request;


import roboguice.util.temp.Ln;

import com.exatun.woop.model.json.user.UserCreation;
import com.exatun.woop.model.json.user.UserCreationResult;
import com.exatun.woop.tags.ConstantsUrl;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.jackson.JacksonFactory;
import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;

public class RegistrationRequest  extends GoogleHttpClientSpiceRequest<UserCreationResult>{
	private String baseUrl;
	private UserCreation userData;
	
	public RegistrationRequest(UserCreation userData) {
		super(UserCreationResult.class);
		// TODO Auto-generated constructor stub
		this.baseUrl = ConstantsUrl.WBS_ROOT + ConstantsUrl.WBS_USER_REGISTRATION;
		this.userData = userData;
		//RetryPolicy retryPolicy = new RetryPolicy();
		this.setRetryPolicy(null);
	}

	@Override
	public UserCreationResult loadDataFromNetwork() throws Exception {
		// TODO Auto-generated method stub
		Ln.d( "Call web service " + baseUrl );
	     HttpRequest request = getHttpRequestFactory()//
	                .buildPostRequest(new GenericUrl(baseUrl), null);
	     
	     JsonHttpContent jsonHttpContent = new JsonHttpContent(new JacksonFactory(), userData);
	     request.setContent(jsonHttpContent);
	     request.getHeaders().setContentType("application/json");
	     request.getHeaders().setAccept("application/json");
	     request.setNumberOfRetries(0);
	     //request.setReadTimeout(readTimeout);
	     //request.setUnsuccessfulResponseHandler(unsuccessfulResponseHandler)
	     request.setParser( new JacksonFactory().createJsonObjectParser() );
	     return request.execute().parseAs( getResultType() );
	}
	
	
	
}

