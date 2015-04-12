package com.krs.parking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class WebServiceBhoopiActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Constant_zip_country.ReadWebService_ZipCountry(Constant_zip_country.ID_VALUE);
        
        Toast.makeText(WebServiceBhoopiActivity.this, "id: "+Constant_zip_country.Zip_Country_Values.mID, Toast.LENGTH_SHORT).show();
        if(Constant_zip_country.Zip_Country_Values.mVOORWAARDEN=="")
        {
        	Toast.makeText(WebServiceBhoopiActivity.this, " blank ", Toast.LENGTH_SHORT).show();
        }
        else
        {
        	Toast.makeText(WebServiceBhoopiActivity.this, ""+Constant_zip_country.Zip_Country_Values.mVOORWAARDEN, Toast.LENGTH_SHORT).show();        	
        }        
    }
}