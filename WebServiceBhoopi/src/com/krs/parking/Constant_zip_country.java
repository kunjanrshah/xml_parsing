package com.krs.parking;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


public class Constant_zip_country 
{
	public static String zip_country_url="http://www.schiphol-parkeren.nl/xml/voorwaarden.asp?id=%s";
	public static final String ID_KEY = "country";
	public static final int ID_VALUE = 53;
	
	
	public static class Zip_Country_Tags
	{
		public static final String ITEMS = "items";
		public static final String COMPANY = "company";
		public static final String ID = "id";
		public static final String VOORWAARDEN = "voorwaarden";

	}
	
	public static class Zip_Country_Values
	{
			public static int mID;
			public static String mVOORWAARDEN="";
	}
	
	public static void ClearData()
	{
		Zip_Country_Values.mID=0;
		Zip_Country_Values.mVOORWAARDEN="";
		Utility.GC();
	}
	
	public static void ReadWebService_ZipCountry(int id)
	{
		ClearData();
		
		InputStream mInputStream = null;
		try
		{
			String URL=String.format(zip_country_url, id);
			System.out.println("kunjan: "+URL);
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
