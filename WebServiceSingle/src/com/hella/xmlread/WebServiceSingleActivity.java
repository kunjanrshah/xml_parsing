package com.hella.xmlread;
import com.hella.xmlread.Constant_Single.WebService_Single_Values;

import android.app.Activity;
import android.os.Bundle;

public class WebServiceSingleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Constant_Single.WebService_ReadProximityLang(Constant_Single.ID_VALUE);  
        
        System.out.println("id: "+Constant_Single.WebService_Single_Values.mID.toString());      
        System.out.println("Longitude : "+Constant_Single.WebService_Single_Values.mLongitude.toString());  
        System.out.println("Latitude : "+Constant_Single.WebService_Single_Values.mLatitude.toString());  
        System.out.println("Company : "+Constant_Single.WebService_Single_Values.mCompany.toString());  
        System.out.println("Street : "+WebService_Single_Values.WebService_Single_Values_Address.mStreet.toString());  
        System.out.println("Number : "+WebService_Single_Values.WebService_Single_Values_Address.mNumber.toString());  
        System.out.println("PostCode : "+WebService_Single_Values.WebService_Single_Values_Address.mPostcode.toString());  
        System.out.println("City : "+WebService_Single_Values.WebService_Single_Values_Address.mCity.toString());  

        System.out.println("Phone : "+WebService_Single_Values.WebService_Single_Values_Contanct.mPhone.toString());  
        System.out.println("Fax : "+WebService_Single_Values.WebService_Single_Values_Contanct.mFax.toString());  
        System.out.println("Email : "+WebService_Single_Values.WebService_Single_Values_Contanct.mEmail.toString());  
        System.out.println("Web : "+WebService_Single_Values.WebService_Single_Values_Contanct.mWeb.toString());  
        System.out.println("Week Morning From : "+WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Morning.mFrom.toString());     
        System.out.println("Week Morning To : "+WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Morning.mTo.toString());  
        
        System.out.println("Week Midday From : "+WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Midday.mFrom.toString());  
        System.out.println("Week Midday To : "+WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Midday.mTo.toString());          
        
        System.out.println("Weekend Morning From : "+WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Morning.mFrom.toString());
        System.out.println("Weekend Morning To : "+WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Morning.mTo.toString());  
        
        System.out.println("Weekend Midday From : "+	WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Midday.mFrom.toString());  
        System.out.println("Weekend Midday To: "+WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Midday.mTo.toString());  

    
    }
}