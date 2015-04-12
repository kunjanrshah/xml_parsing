package com.hella.xmlread;

import android.app.Activity;
import android.os.Bundle;

public class WebServiceZip_CountryActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Constant_zip_country.ReadWebService_ZipCountry(Constant_zip_country.COUNTRY_VALUE, Constant_zip_country.QUERY_VALUE,Constant_zip_country.PAGE_VALUE);
        
        for (int i = 0; i < Constant_zip_country.Zip_Country_Values.mID.size(); i++) 
		{
			System.out.println((i+1) +" ID = " +  Constant_zip_country.Zip_Country_Values.mID.get(i).toString());
			System.out.println((i+1) +" Longitude = " +  Constant_zip_country.Zip_Country_Values.mLongitude.get(i).toString());
			System.out.println((i+1) +" Latitude = " +  Constant_zip_country.Zip_Country_Values.mLatitude.get(i).toString());
			System.out.println((i+1) +" Company = " +  Constant_zip_country.Zip_Country_Values.mCompany.get(i).toString());
			System.out.println((i+1) +" ZIP = " +  Constant_zip_country.Zip_Country_Values.mZIP.get(i).toString());
			System.out.println((i+1) +" CITY = " +  Constant_zip_country.Zip_Country_Values.mCITY.get(i).toString());
			System.out.println((i+1) +" DIST = " +  Constant_zip_country.Zip_Country_Values.mDIST.get(i).toString());
			System.out.println((i+1) +" DISTUNIT = " + Constant_zip_country.Zip_Country_Values.mDISTUNIT.get(i).toString());			
		}
    }
}