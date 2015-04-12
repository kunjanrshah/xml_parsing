package com.hella.readxml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetZipLnglat_XMLHandler extends DefaultHandler  
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
        
        if (localName.equals(Constant_Zip_Lnglat.zip_lnglat_tags.LIST))
        {		 
        	bool_list=true;
		}
		else if (localName.equals(Constant_Zip_Lnglat.zip_lnglat_tags.HSP)) 
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
				if (localName.equalsIgnoreCase(Constant_Zip_Lnglat.zip_lnglat_tags.ID))
				{			
					Constant_Zip_Lnglat.zip_lnglat_values.mID.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Zip_Lnglat.zip_lnglat_tags.LONGITUDE))
				{   
					Constant_Zip_Lnglat.zip_lnglat_values.mLongitude.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Zip_Lnglat.zip_lnglat_tags.LATITUDE))
				{
					Constant_Zip_Lnglat.zip_lnglat_values.mLatitude.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Zip_Lnglat.zip_lnglat_tags.COMPANY))
				{
					Constant_Zip_Lnglat.zip_lnglat_values.mCompany.add(currentValue.trim());
				}				
				else if(localName.equalsIgnoreCase(Constant_Zip_Lnglat.zip_lnglat_tags.ZIP))
				{
					Constant_Zip_Lnglat.zip_lnglat_values.mZIP.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Zip_Lnglat.zip_lnglat_tags.CITY))
				{
					Constant_Zip_Lnglat.zip_lnglat_values.mCITY.add(currentValue.trim());
				}				
				else if(localName.equalsIgnoreCase(Constant_Zip_Lnglat.zip_lnglat_tags.DIST))
				{
					Constant_Zip_Lnglat.zip_lnglat_values.mDIST.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Zip_Lnglat.zip_lnglat_tags.DISTUNIT))
				{
					Constant_Zip_Lnglat.zip_lnglat_values.mDISTUNIT.add(currentValue.trim());
				}
			}
			
			if (localName.equals(Constant_Zip_Lnglat.zip_lnglat_tags.LIST))
			{
					/** End ROW*/ 
				bool_list=false;
			}
			else if (localName.equals(Constant_Zip_Lnglat.zip_lnglat_tags.HSP))
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
