package com.exatun.woop.request;

import roboguice.util.temp.Ln;

import com.exatun.woop.model.json.search.user.SearchUserResult;
import com.exatun.woop.tags.ConstantsUrl;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.jackson.JacksonFactory;
import com.octo.android.robospice.request.googlehttpclient.GoogleHttpClientSpiceRequest;

public class SearchUserRequest extends GoogleHttpClientSpiceRequest<SearchUserResult> {

	private String baseUrl;
	
	public SearchUserRequest(String query) {
		super(SearchUserResult.class);
		// TODO Auto-generated constructor stub
		this.baseUrl = String.format(ConstantsUrl.WBS_ROOT + ConstantsUrl.WBS_SEARCH_USER, query);
	}

	@Override
	public SearchUserResult loadDataFromNetwork() throws Exception {
		 Ln.d( "Call web service " + baseUrl );
	     HttpRequest request = getHttpRequestFactory()//
	                .buildGetRequest( new GenericUrl( baseUrl ) );
	     request.setParser( new JacksonFactory().createJsonObjectParser() );
	     return request.execute().parseAs( getResultType() );
	}

}
