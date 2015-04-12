package com.hella.xmlread;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class Constant_Single
{
	public static final String Single_URL="http://partnerfinderservice.de/single/?id=%s";
	
	public static final String ID_KEY="id";
	public static String ID_VALUE="9f0ccdb69ae0128d48e855a11cd3b1ef";
	
	public static class WebService_Single_Tags
	{
		public static final String HSP="hsp";
		public static final String ID="id";
		public static final String LONGITUDE="longitude";
		public static final String LATITUDE="latitude";
		public static final String COMPANY="company";
		
		public static final String ADDRESS="address";		
			public static final String STREET="street";
			public static final String NUMBER="number";
			public static final String POSTCODE="postcode";
			public static final String CITY="city";
		
		public static final String CONTANCT="contact";	
			public static final String PHONE="phone";
			public static final String FAX="fax";
			public static final String EMAIL="email";
			public static final String WEB="web";
		
		public static final String TIME="time";		
			public static final String WEEK="week";
				public static final String MORNING="morning";
					public static final String FROM="from";	
					public static final String TO="to";
				public static final String MIDDAY="midday";					
			public static final String WEEKEND="weekend";	
	}
	
	public static class WebService_Single_Values
	{
		public static String mID="";		
		public static String mLongitude="";
		public static String mLatitude="";
		public static String mCompany="";
		
		public static class WebService_Single_Values_Address
		{
			public static String mStreet="";
			public static String mNumber="";
			public static String mPostcode="";
			public static String mCity="";
		}
		
		public static class WebService_Single_Values_Contanct
		{
			public static String mPhone="";
			public static String mFax="";
			public static String mEmail="";
			public static String mWeb="";
		}
		
		public static class WebService_Single_Values_Time
		{
			public static class WebService_Single_Values_Week
			{
				public static class WebService_Single_Values_Morning
				{
					public static String mFrom="";
					public static String mTo="";
				}
				public static class WebService_Single_Values_Midday
				{
					public static String mFrom="";
					public static String mTo="";
				}
				
			}
			public static class WebService_Single_Values_Weekend
			{
				public static class WebService_Single_Values_Morning
				{
					public static String mFrom="";
					public static String mTo="";
				}
				public static class WebService_Single_Values_Midday
				{
					public static String mFrom="";
					public static String mTo="";
				}
			}
		}		
	}
	
	public static void ClearData()
	{
		WebService_Single_Values.mID="";		
		WebService_Single_Values.mLongitude="";
		WebService_Single_Values.mLatitude="";
		WebService_Single_Values.mCompany="";
		WebService_Single_Values.WebService_Single_Values_Address.mStreet="";
		WebService_Single_Values.WebService_Single_Values_Address.mNumber="";
		WebService_Single_Values.WebService_Single_Values_Address.mPostcode="";
		WebService_Single_Values.WebService_Single_Values_Address.mCity="";	

		WebService_Single_Values.WebService_Single_Values_Contanct.mPhone="";
		WebService_Single_Values.WebService_Single_Values_Contanct.mFax="";
		WebService_Single_Values.WebService_Single_Values_Contanct.mEmail="";
		WebService_Single_Values.WebService_Single_Values_Contanct.mWeb="";
		
		WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Morning.mFrom="";
		WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Morning.mTo="";
		
		WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Midday.mFrom="";
		WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Midday.mTo="";
		
		WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Morning.mFrom="";
		WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Morning.mTo="";
		
		WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Midday.mFrom="";
		WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Midday.mTo="";
	}
	
	public static void WebService_ReadProximityLang(String id)
	{
		ClearData();
		InputStream mInputStream = null;
		try 
		{
			String ProximityLang_Url=String.format(Single_URL, id);
     		mInputStream = Utility.GetConnectionInputStream(ProximityLang_Url);	
    		 
 			/** Handling XML */
 			SAXParserFactory mSAXParserFactory = SAXParserFactory.newInstance();
 			SAXParser mSAXParser = mSAXParserFactory.newSAXParser();
 			XMLReader mXMLReader = mSAXParser.getXMLReader();

 			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
 			GetSingle_XMLHandler mGetSingle_XMLHandler = new GetSingle_XMLHandler();
 			mXMLReader.setContentHandler(mGetSingle_XMLHandler);

 			if (mInputStream != null)
 			{
 				InputSource mInputSource = new InputSource(mInputStream); 	
 				mXMLReader.parse(mInputSource);
 			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally{
			Utility.closeSilently(mInputStream);
		}
	}
}
