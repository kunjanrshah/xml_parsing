package com.hella.xmlread;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.util.Log;

public class Constant_Proximity {
	
	// Webservice Variable
	public static final String GETPROXIMITY_URL = "http://partnerfinderservice.de/proximity/?lat=%s&lng=%s&page=%s";
	public static final String LAT_KEY = "lat";
	public static final float LAT_VALUE = 49.781811f;
	public static final String LNG_KEY = "lng";
	public static final float LNG_VALUE = 7.695460f;
	public static final String PAGE_KEY = "page";
	public static final int PAGE_VALUE = 1;

	// For All Response
	public static class GET_PROXIMITY_TAG {
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

	// Variables
	public static class GET_PROXIMITY_VALUE {

		public static ArrayList<String> mID = new ArrayList<String>();
		public static ArrayList<String> mLongitude = new ArrayList<String>();
		public static ArrayList<String> mLatitude = new ArrayList<String>();
		public static ArrayList<String> mCompany = new ArrayList<String>();
		public static ArrayList<String> mZIP = new ArrayList<String>();
		public static ArrayList<String> mCITY = new ArrayList<String>();
		public static ArrayList<String> mDIST = new ArrayList<String>();
		public static ArrayList<String> mDISTUNIT = new ArrayList<String>();
	
	}

	public static void ClearData() {
		GET_PROXIMITY_VALUE.mID.clear();
		GET_PROXIMITY_VALUE.mLongitude.clear();
		GET_PROXIMITY_VALUE.mLatitude.clear();
		GET_PROXIMITY_VALUE.mCompany.clear();
		GET_PROXIMITY_VALUE.mZIP.clear();
		GET_PROXIMITY_VALUE.mCITY.clear();
		GET_PROXIMITY_VALUE.mDIST.clear();
		GET_PROXIMITY_VALUE.mDISTUNIT.clear();
		Utility.GC();
	}

	public static void Read_WebService_Proximity(float lat, float lng, int page) {
		ClearData();
		InputStream mInputStream = null;
		try {
			String URL = String.format(Constant_Proximity.GETPROXIMITY_URL,
					lat, lng, page);
			mInputStream = Utility.GetConnectionInputStream(URL);

			// Log.i("Prox Res ",mCommonClass.InputStreamToString(mInputStream).toString());

			/** Handling XML */
			SAXParserFactory mSAXParserFactory = SAXParserFactory.newInstance();
			SAXParser mSAXParser = mSAXParserFactory.newSAXParser();
			XMLReader mXMLReader = mSAXParser.getXMLReader();

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			GetProximity_XMLHandler mGetProximity_XMLHandler = new GetProximity_XMLHandler();
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
