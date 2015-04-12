package com.hella.xmlread;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetZipCountry_XMLHandler extends DefaultHandler  
{
	String currentValue = null;
	private boolean currentElement = false;
	private boolean bool_list = false;
	private boolean bool_hsp = false;	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException 
	{
		currentElement = true;
        currentValue="";    
        
//        Log.i("Start Localname", localName);
        
        if (localName.equals(Constant_zip_country.Zip_Country_Tags.LIST))
        {		 
        	bool_list=true;
		}
		else if (localName.equals(Constant_zip_country.Zip_Country_Tags.HSP)) 
		{		 
			bool_hsp=true;
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException 
	{
		currentElement = false;			
//		 Log.i("End Localname", localName);
//		 Log.i("Current Value", currentValue);
		
		if(bool_list)
		{
			if(bool_hsp)
			{
				if (localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.ID))
				{			
					Constant_zip_country.Zip_Country_Values.mID.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.LONGITUDE))
				{   
					Constant_zip_country.Zip_Country_Values.mLongitude.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.LATITUDE))
				{
					Constant_zip_country.Zip_Country_Values.mLatitude.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.COMPANY))
				{
					Constant_zip_country.Zip_Country_Values.mCompany.add(currentValue.trim());
				}				
				else if(localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.ZIP))
				{
					Constant_zip_country.Zip_Country_Values.mZIP.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.CITY))
				{
					Constant_zip_country.Zip_Country_Values.mCITY.add(currentValue.trim());
				}				
				else if(localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.DIST))
				{
					Constant_zip_country.Zip_Country_Values.mDIST.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.DISTUNIT))
				{
					Constant_zip_country.Zip_Country_Values.mDISTUNIT.add(currentValue.trim());
				}
			}
			
			if (localName.equals(Constant_zip_country.Zip_Country_Tags.LIST))
			{
					/** End ROW*/ 
				bool_list=false;
			}
			else if (localName.equals(Constant_zip_country.Zip_Country_Tags.HSP))
			{
				/** End ROOT*/ 
				bool_hsp=false;
			}			
		}		
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException 
	{
		if (currentElement) 
		{
			currentValue = new String(ch, start, length);
			currentElement = false;
		}
		
	}
}
