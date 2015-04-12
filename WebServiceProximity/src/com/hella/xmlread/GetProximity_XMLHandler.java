package com.hella.xmlread;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;


public class GetProximity_XMLHandler extends DefaultHandler 
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
        if (localName.equals(Constant_Proximity.GET_PROXIMITY_TAG.LIST))
        {		 
        	bool_list=true;
		}
		else if (localName.equals(Constant_Proximity.GET_PROXIMITY_TAG.HSP)) 
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
				if (localName.equalsIgnoreCase(Constant_Proximity.GET_PROXIMITY_TAG.ID))
				{			
					Constant_Proximity.GET_PROXIMITY_VALUE.mID.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Proximity.GET_PROXIMITY_TAG.LONGITUDE))
				{   
					Constant_Proximity.GET_PROXIMITY_VALUE.mLongitude.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Proximity.GET_PROXIMITY_TAG.LATITUDE))
				{
					Constant_Proximity.GET_PROXIMITY_VALUE.mLatitude.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Proximity.GET_PROXIMITY_TAG.COMPANY))
				{
					Constant_Proximity.GET_PROXIMITY_VALUE.mCompany.add(currentValue.trim());
				}				
				else if(localName.equalsIgnoreCase(Constant_Proximity.GET_PROXIMITY_TAG.ZIP))
				{
					Constant_Proximity.GET_PROXIMITY_VALUE.mZIP.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Proximity.GET_PROXIMITY_TAG.CITY))
				{
					Constant_Proximity.GET_PROXIMITY_VALUE.mCITY.add(currentValue.trim());
				}				
				else if(localName.equalsIgnoreCase(Constant_Proximity.GET_PROXIMITY_TAG.DIST))
				{
					Constant_Proximity.GET_PROXIMITY_VALUE.mDIST.add(currentValue.trim());
				}
				else if(localName.equalsIgnoreCase(Constant_Proximity.GET_PROXIMITY_TAG.DISTUNIT))
				{
					Constant_Proximity.GET_PROXIMITY_VALUE.mDISTUNIT.add(currentValue.trim());
				}
			}
			
			if (localName.equals(Constant_Proximity.GET_PROXIMITY_TAG.LIST))
			{
					/** End ROW*/ 
				bool_list=false;
			}
			else if (localName.equals(Constant_Proximity.GET_PROXIMITY_TAG.HSP))
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
