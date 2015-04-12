package com.hella.xmlread;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetProximityLang_XMLHandler extends DefaultHandler
{
	String currentValue = null;
	private boolean currentElement = false;
	private boolean bool_list = false;
	private boolean bool_hsp = false;	
	
	@Override
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException 
	{
		currentElement = true;
        currentValue="";    
        
//        Log.i("Start Localname", localName);
        if (localName.equals(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.LIST))
        {		 
        	bool_list=true;
		}
		else if (localName.equals(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.HSP)) 
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
				if (localName.equalsIgnoreCase(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.ID))
				{			
					Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mID.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.LONGITUDE))
				{   
					Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mLongitude.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.LATITUDE))
				{
					Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mLatitude.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.COMPANY))
				{
					Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mCompany.add(currentValue.trim());
				}				
				else if(localName.equalsIgnoreCase(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.ZIP))
				{
					Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mZIP.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.CITY))
				{
					Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mCITY.add(currentValue.trim());
				}				
				else if(localName.equalsIgnoreCase(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.DIST))
				{
					Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mDIST.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.DISTUNIT))
				{
					Constant_ProximityLang.GET_PROXIMITYLANG_VALUES.mDISTUNIT.add(currentValue.trim());
				}
			}
			
			if (localName.equals(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.LIST))
			{
					/** End ROW*/ 
				bool_list=false;
			}
			else if (localName.equals(Constant_ProximityLang.GET_PROXIMITYLANG_TAG.HSP))
			{
				/** End ROOT*/ 
				bool_hsp=false;
			}			
		}
	}
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
