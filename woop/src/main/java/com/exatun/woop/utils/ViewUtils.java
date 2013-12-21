package com.exatun.woop.utils;

import android.widget.TextView;

public class ViewUtils {

	public static String getViewText(TextView v){
		String text = null;
		if(v != null){
			text = v.getText().toString();
		}
		return text;
	}
}
