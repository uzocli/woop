package com.exatun.woop.utils;


import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager
{
	
  private static PreferencesManager sInstance;
  private SharedPreferences mSharedPreferences;
  private static String prefFileName;

  private PreferencesManager(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    this.mSharedPreferences = localSharedPreferences;
  }

  
  public static PreferencesManager getInstance(Context paramContext, String preferenceFileName)
  {
	synchronized(sInstance){
	    //monitorenter;
	    try
	    {
	      if (sInstance == null)
	      {
	    	prefFileName = preferenceFileName;
	        Context localContext = paramContext.getApplicationContext();
	        sInstance = new PreferencesManager(localContext);
	      }
	      PreferencesManager localPreferencesManager = sInstance;
	      //monitorexit;
	      return localPreferencesManager;
	    }
	    finally
	    {
	      //localObject = finally;
	      //monitorexit;
	    }
	    //throw localObject;
	}
  }

  public String getIdent()
  {
    return this.mSharedPreferences.getString("ID_NUM_COMPTE_CE", "");
  }

  public void setIdent(String paramString)
  {
    SharedPreferences.Editor localEditor1 = this.mSharedPreferences.edit();
    SharedPreferences.Editor localEditor2 = localEditor1.putString("ID_NUM_COMPTE_CE", paramString);
    boolean bool = localEditor1.commit();
  }
}
