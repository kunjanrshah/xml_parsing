package com.hella.readxml;

import android.app.Activity;
import android.os.Bundle;

public class WebServiceZip_LnglatActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Constant_Zip_Lnglat.readWebservice_ZipLnglat(Constant_Zip_Lnglat.lat_value, Constant_Zip_Lnglat.lng_value, Constant_Zip_Lnglat.QUERY_VALUE, Constant_Zip_Lnglat.PAGE_VALUE);
        for (int i = 0; i < Constant_Zip_Lnglat.zip_lnglat_values.mID.size(); i++) 
		{
			System.out.println((i+1) +" ID = " +  Constant_Zip_Lnglat.zip_lnglat_values.mID.get(i).toString());
			System.out.println((i+1) +" Longitude = " +  Constant_Zip_Lnglat.zip_lnglat_values.mLongitude.get(i).toString());
			System.out.println((i+1) +" Latitude = " +  Constant_Zip_Lnglat.zip_lnglat_values.mLatitude.get(i).toString());
			System.out.println((i+1) +" Company = " +  Constant_Zip_Lnglat.zip_lnglat_values.mCompany.get(i).toString());
			System.out.println((i+1) +" ZIP = " +  Constant_Zip_Lnglat.zip_lnglat_values.mZIP.get(i).toString());
			System.out.println((i+1) +" CITY = " +  Constant_Zip_Lnglat.zip_lnglat_values.mCITY.get(i).toString());
			System.out.println((i+1) +" DIST = " +  Constant_Zip_Lnglat.zip_lnglat_values.mDIST.get(i).toString());
			System.out.println((i+1) +" DISTUNIT = " + Constant_Zip_Lnglat.zip_lnglat_values.mDISTUNIT.get(i).toString());			
		}
    }
}