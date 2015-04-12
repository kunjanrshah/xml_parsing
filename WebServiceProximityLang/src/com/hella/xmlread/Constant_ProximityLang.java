package com.hella.xmlread;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.util.Log;

public class Constant_ProximityLang
{

	//WebService Input Variables
	public static final String URL="http://partnerfinderservice.de/proximity/?page=%s&lat=%s&lng=%s&lang=%s";
	public static final String PAGE_KEY="page";
	public static int PAGE_VALUE=1;
	public static final String LAT_KEY="lat";
	public static float LAT_VALUE=48.205433f;
	public static String LNG_KEY="lng";
	public static float LNG_VALUE=15.618343f;
	public static final String LANG_KEY="lang";
	public static String LANG_VALUE="at";
	
	//WebService Tag Variables
	public static class GET_PROXIMITYLANG_TAG
	{
		public static final String LIST = "list";
		public static final String HSP = "hsp";
		public static final String ID = "id";
		public static final String LONGITUDE = "longitude";
		public static final String LATITUDE = "latitude";
		public static final String COMPANY = "company";
		public static final String ZIP = "zip";
		public static final String CITY = "city";
		public static final String DIST = "dist";
		public static final String DISTUNIT = "distunit";		
	}
	
	//WebService Tag Values
	public static class GET_PROXIMITYLANG_VALUES
	{
		public static ArrayList<String> mID = new ArrayList<String>();
		public static ArrayList<String> mLongitude = new ArrayList<String>();
		public static ArrayList<String> mLatitude = new ArrayList<String>();
		public static ArrayList<String> mCompany = new ArrayList<String>();
		public static ArrayList<String> mZIP = new ArrayList<String>();
		public static ArrayList<String> mCITY = new ArrayList<String>();
		public static ArrayList<String> mDIST = new ArrayList<String>();
		public static ArrayList<String> mDISTUNIT = new ArrayList<String>();
		// this method use for clear data
	}
	
	//To clear WebService Values
	public static void ClearData()
	{
		GET_PROXIMITYLANG_VALUES.mID.clear();
		GET_PROXIMITYLANG_VALUES.mLongitude.clear();
		GET_PROXIMITYLANG_VALUES.mLatitude.clear();
		GET_PROXIMITYLANG_VALUES.mCompany.clear();
		GET_PROXIMITYLANG_VALUES.mZIP.clear();
		GET_PROXIMITYLANG_VALUES.mCITY.clear();
		GET_PROXIMITYLANG_VALUES.mDIST.clear();
		GET_PROXIMITYLANG_VALUES.mDISTUNIT.clear();
	}
	
	public static void WebService_ReadProximityLang(int page,float lat,float lng,String lang)
	{
		ClearData();
		InputStream mInputStream = null;
		try 
		{
			String ProximityLang_Url=String.format(Constant_ProximityLang.URL, page,lat,lng,lang);
     		mInputStream = Utility.GetConnectionInputStream(ProximityLang_Url);	

			/** Handling XML */
			SAXParserFactory mSAXParserFactory = SAXParserFactory.newInstance();
			SAXParser mSAXParser = mSAXParserFactory.newSAXParser();
			XMLReader mXMLReader = mSAXParser.getXMLReader();

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			GetProximityLang_XMLHandler mGetProximity_XMLHandler = new GetProximityLang_XMLHandler();
			mXMLReader.setContentHandler(mGetProximity_XMLHandler);

			if (mInputStream != null) {
				InputSource mInputSource = new InputSource(mInputStream);
				mXMLReader.parse(mInputSource);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mInputStream != null) {
				try {
					mInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
