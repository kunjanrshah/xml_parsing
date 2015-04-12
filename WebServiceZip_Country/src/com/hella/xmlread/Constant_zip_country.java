package com.hella.xmlread;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


public class Constant_zip_country 
{
	public static String zip_country_url="http://partnerfinderservice.de/zip/?country=%s&query=%s&page=%s";
	public static final String COUNTRY_KEY = "country";
	public static final String COUNTRY_VALUE = "de";
	public static final String QUERY_KEY = "query";
	public static final String QUERY_VALUE = "Gütersloh";
	public static final String PAGE_KEY = "page";
	public static final int PAGE_VALUE = 1;
	
	public static class Zip_Country_Tags
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
	
	public static class Zip_Country_Values
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
	
	public static void ClearData()
	{
		Zip_Country_Values.mID.clear();
		Zip_Country_Values.mLongitude.clear();
		Zip_Country_Values.mLatitude.clear();
		Zip_Country_Values.mCompany.clear();
		Zip_Country_Values.mZIP.clear();
		Zip_Country_Values.mCITY.clear();
		Zip_Country_Values.mDIST.clear();
		Zip_Country_Values.mDISTUNIT.clear();
		Utility.GC();
	}
	
	public static void ReadWebService_ZipCountry(String country,String query,int page)
	{
		ClearData();
		InputStream mInputStream = null;
		try
		{
			String URL=String.format(zip_country_url, country,query,page);		
			mInputStream = Utility.GetConnectionInputStream(URL);
			
			/** Handling XML */
			SAXParserFactory mSAXParserFactory = SAXParserFactory.newInstance();
			SAXParser mSAXParser = mSAXParserFactory.newSAXParser();
			XMLReader mXMLReader = mSAXParser.getXMLReader();

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			GetZipCountry_XMLHandler mGetZipCountry_XMLHandler = new GetZipCountry_XMLHandler();
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
		finally
		{
			if(mInputStream!=null)
			{
				try {
					mInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
