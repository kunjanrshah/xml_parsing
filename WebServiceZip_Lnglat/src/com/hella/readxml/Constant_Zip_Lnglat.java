package com.hella.readxml;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class Constant_Zip_Lnglat 
{
	public static String zip_lnglat_url="http://partnerfinderservice.de/zip/?lat=50.386299&lng=8.320080&query=33311&page=1";
	
	public static final String lat_key = "lat";
	public static final float lat_value = 50.386299f;	
	public static final String lng_key = "lng";
	public static final float lng_value = 8.320080f;	
	public static final String QUERY_KEY = "query";
	public static final String QUERY_VALUE = "Gütersloh";
	public static final String PAGE_KEY = "page";
	public static final int PAGE_VALUE = 1;
	
	public static class zip_lnglat_tags
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
	
	public static class zip_lnglat_values
	{
		public static ArrayList<String> mID = new ArrayList<String>();
		public static ArrayList<String> mLongitude = new ArrayList<String>();
		public static ArrayList<String> mLatitude = new ArrayList<String>();
		public static ArrayList<String> mCompany = new ArrayList<String>();
		public static ArrayList<String> mZIP = new ArrayList<String>();
		public static ArrayList<String> mCITY = new ArrayList<String>();
		public static ArrayList<String> mDIST = new ArrayList<String>();
		public static ArrayList<String> mDISTUNIT = new ArrayList<String>();
	}
	
	public static void cleardata()
	{
		zip_lnglat_values.mID.clear();
		zip_lnglat_values.mLongitude.clear();
		zip_lnglat_values.mLatitude.clear();
		zip_lnglat_values.mCompany.clear();
		zip_lnglat_values.mZIP.clear();
		zip_lnglat_values.mCITY.clear();
		zip_lnglat_values.mDIST.clear();
		zip_lnglat_values.mDISTUNIT.clear();
		Utility.GC();
	}
		
	public static void readWebservice_ZipLnglat(float lat,float lng,String query,int page)
	{
		cleardata();
		InputStream mInputStream = null;		
	
		try
		{
			String URL=String.format(zip_lnglat_url, lat,lng,query,page);
			mInputStream = Utility.GetConnectionInputStream(URL);
			/** Handling XML */
			SAXParserFactory mSAXParserFactory = SAXParserFactory.newInstance();
			SAXParser mSAXParser = mSAXParserFactory.newSAXParser();
			XMLReader mXMLReader = mSAXParser.getXMLReader();

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			GetZipLnglat_XMLHandler mGetZipCountry_XMLHandler = new GetZipLnglat_XMLHandler();
			mXMLReader.setContentHandler(mGetZipCountry_XMLHandler);
			
			if (mInputStream != null) 
			{
				InputSource mInputSource = new InputSource(mInputStream);
				mXMLReader.parse(mInputSource);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
}
