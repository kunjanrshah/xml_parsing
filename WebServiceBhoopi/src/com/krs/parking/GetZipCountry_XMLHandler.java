package com.krs.parking;

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
        
        if (localName.equals(Constant_zip_country.Zip_Country_Tags.ITEMS))
        {		 
        	bool_list=true;
		}
		else if (localName.equals(Constant_zip_country.Zip_Country_Tags.COMPANY)) 
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
					Constant_zip_country.Zip_Country_Values.mID=Integer.parseInt(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_zip_country.Zip_Country_Tags.VOORWAARDEN))
				{   
					Constant_zip_country.Zip_Country_Values.mVOORWAARDEN=currentValue.trim();
				}
				
			}
			
			if (localName.equals(Constant_zip_country.Zip_Country_Tags.ITEMS))
			{
					/** End ROW*/ 
				bool_list=false;
			}
			else if (localName.equals(Constant_zip_country.Zip_Country_Tags.COMPANY))
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
