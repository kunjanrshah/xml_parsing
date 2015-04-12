package com.hella.xmlread;

import android.app.Activity;
import android.os.Bundle;

public class WebServiceProximityLangActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       Constant_ProximityLang.WebService_ReadProximityLang(Constant_ProximityLang.PAGE_VALUE,Constant_ProximityLang.LAT_VALUE,Constant_ProximityLang.LNG_VALUE,Constant_ProximityLang.LANG_VALUE);
       for(int i=0; i<Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mID.size(); i++)
       {
    	   System.out.println((i+1) +" ID = " +Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mID.get(i).toString());
    	   System.out.println((i+1) +" Longitude = " +Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mLongitude.get(i).toString());
    	   System.out.println((i+1) +" Latitude = " +Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mLatitude.get(i).toString());
    	   System.out.println((i+1) +" Company = " +Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mCompany.get(i).toString());
    	   System.out.println((i+1) +" ZIP = " +Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mZIP.get(i).toString());
    	   System.out.println((i+1) +" CITY = " +Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mCITY.get(i).toString());
    	   System.out.println((i+1) +" DIST = " +Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mDIST.get(i).toString());
    	   System.out.println((i+1) +" DISTUNIT = " +Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mDISTUNIT.get(i).toString());
       }
       
        
    }
}