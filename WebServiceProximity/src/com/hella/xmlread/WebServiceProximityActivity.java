package com.hella.xmlread;
import android.app.Activity;
import android.os.Bundle;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class WebServiceProximityActivity extends Activity 
{

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Constant_Proximity.Read_WebService_Proximity(Constant_Proximity.LAT_VALUE,Constant_Proximity.LNG_VALUE,Constant_Proximity.PAGE_VALUE);
        
        
        for (int i = 0; i < Constant_Proximity.GET_PROXIMITY_VALUE.mID.size(); i++) 
		{
			System.out.println((i+1) +" ID = " +  Constant_Proximity.GET_PROXIMITY_VALUE.mID.get(i).toString());
			System.out.println((i+1) +" Longitude = " +  Constant_Proximity.GET_PROXIMITY_VALUE.mLongitude.get(i).toString());
			System.out.println((i+1) +" Latitude = " +  Constant_Proximity.GET_PROXIMITY_VALUE.mLatitude.get(i).toString());
			System.out.println((i+1) +" Company = " +  Constant_Proximity.GET_PROXIMITY_VALUE.mCompany.get(i).toString());
			System.out.println((i+1) +" ZIP = " +  Constant_Proximity.GET_PROXIMITY_VALUE.mZIP.get(i).toString());
			System.out.println((i+1) +" CITY = " +  Constant_Proximity.GET_PROXIMITY_VALUE.mCITY.get(i).toString());
			System.out.println((i+1) +" DIST = " +  Constant_Proximity.GET_PROXIMITY_VALUE.mDIST.get(i).toString());
			System.out.println((i+1) +" DISTUNIT = " +  Constant_Proximity.GET_PROXIMITY_VALUE.mDISTUNIT.get(i).toString());			
		}
    }
}