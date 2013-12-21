package com.exatun.woop.request;

import roboguice.util.temp.Ln;
import android.util.Base64;

import com.exatun.woop.model.json.user.User;
import com.exatun.woop.model.json.user.UserAuthResult;
import com.exatun.woop.tags.ConstantsUrl;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.jackson.JacksonFactory;
import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;

public class AuthRequest  extends GoogleHttpClientSpiceRequest<UserAuthResult>{
	private String baseUrl;
	private String email;
	private String password;
	
	public AuthRequest(String email, String password) {
		super(UserAuthResult.class);
		// TODO Auto-generated constructor stub
		this.baseUrl = ConstantsUrl.WBS_ROOT + ConstantsUrl.WBS_USER_AUTH;
		this.email = email;
		this.password = password;
		this.setRetryPolicy(null);
	}

	@Override
	public UserAuthResult loadDataFromNetwork() throws Exception {
		// TODO Auto-generated method stub
		Ln.d( "Call web service " + baseUrl );
	     HttpRequest request = getHttpRequestFactory()//
	                .buildPostRequest(new GenericUrl(baseUrl), null);
	     
	     request.getHeaders().setAuthorization(getB64Auth(email, password));
	     request.setNumberOfRetries(0);
	     request.setParser( new JacksonFactory().createJsonObjectParser() );
	     return request.execute().parseAs( getResultType() );
	}
	
	private String getB64Auth (String login, String pwd) {
		String source = login + ":" + pwd;
		return "Basic "+Base64.encodeToString(source.getBytes(),Base64.URL_SAFE|Base64.NO_WRAP);
	}
}

