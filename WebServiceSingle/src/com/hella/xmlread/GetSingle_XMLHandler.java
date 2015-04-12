package com.hella.xmlread;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class GetSingle_XMLHandler extends DefaultHandler
{
	String currentValue = null;
	private boolean currentElement = false;	
	private boolean bool_hsp = false;
	private boolean bool_address = false;	
	private boolean bool_contact = false;	
	private boolean bool_time = false;	
	private boolean bool_week = false;	
	private boolean bool_weekend = false;
	private boolean bool_morning = false;
	private boolean bool_midday = false;
	
	@Override
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException 
	{
		currentElement = true;
        currentValue="";       
        Log.i("Start Localname", localName);
        if (localName.equals(Constant_Single.WebService_Single_Tags.HSP))
        {		 
        	Log.i("hsp true : ", Constant_Single.WebService_Single_Tags.HSP);
        	bool_hsp=true;
		}
		else if (localName.equals(Constant_Single.WebService_Single_Tags.ADDRESS)) 
		{		 
			bool_address=true;
		}
		else if (localName.equals(Constant_Single.WebService_Single_Tags.CONTANCT)) 
		{		 
			bool_contact=true;
		}
		else if (localName.equals(Constant_Single.WebService_Single_Tags.TIME)) 
		{		 
			bool_time=true;
		}
		else if (localName.equals(Constant_Single.WebService_Single_Tags.WEEK)) 
		{		 
			bool_week=true;
		}
		else if (localName.equals(Constant_Single.WebService_Single_Tags.WEEKEND)) 
		{		 
			bool_weekend=true;
		}  
		else if (localName.equals(Constant_Single.WebService_Single_Tags.MORNING)) 
		{		 
			bool_morning=true;
		}    
		else if (localName.equals(Constant_Single.WebService_Single_Tags.MIDDAY)) 
		{		 
			bool_midday=true;
		}  
	}	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		currentElement = false;			
		 Log.i("End Localname", localName);
		 Log.i("End Current Value", currentValue);
		
		if(bool_hsp)
		{
			if (localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.ID))
			{			
				Constant_Single.WebService_Single_Values.mID=currentValue.trim();	
			}
			else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.LONGITUDE))
			{   
				Constant_Single.WebService_Single_Values.mLongitude=currentValue.trim();
			}
			else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.LATITUDE))
			{
				Constant_Single.WebService_Single_Values.mLatitude=currentValue.trim();
			}
			else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.COMPANY))
			{
				Constant_Single.WebService_Single_Values.mCompany=currentValue.trim();
			}			
			else if(bool_address)
			{								
				if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.STREET))
				{
					Constant_Single.WebService_Single_Values.WebService_Single_Values_Address.mStreet=currentValue.trim();
				}
				else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.NUMBER))
				{
					Constant_Single.WebService_Single_Values.WebService_Single_Values_Address.mNumber=currentValue.trim();
				}				
				else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.POSTCODE))
				{
					Constant_Single.WebService_Single_Values.WebService_Single_Values_Address.mPostcode=currentValue.trim();
				}
				else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.CITY))
				{
					Constant_Single.WebService_Single_Values.WebService_Single_Values_Address.mCity=currentValue.trim();
				}
			}
			else if(bool_contact)
			{		
				
				
				if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.PHONE))
				{
					Constant_Single.WebService_Single_Values.WebService_Single_Values_Contanct.mPhone=currentValue.trim();
				}
				else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.FAX))
				{
					Constant_Single.WebService_Single_Values.WebService_Single_Values_Contanct.mFax=currentValue.trim();
				}				
				else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.EMAIL))
				{
					Constant_Single.WebService_Single_Values.WebService_Single_Values_Contanct.mEmail=currentValue.trim();
				}
				else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.WEB))
				{
					Constant_Single.WebService_Single_Values.WebService_Single_Values_Contanct.mWeb=currentValue.trim();
				}
			}
			else if(bool_time)
			{			
				if(bool_week)
				{
					if(bool_morning)
					{
						if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.TO))
						{
							Constant_Single.WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Morning.mTo=currentValue.trim();
						}
						else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.FROM))
						{
							Constant_Single.WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Morning.mFrom=currentValue.trim();
						}					
					}
					else if(bool_midday)
					{
						if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.TO))
						{
							Constant_Single.WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Midday.mTo=currentValue.trim();
						}
						else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.FROM))
						{
							Constant_Single.WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Week.WebService_Single_Values_Midday.mFrom=currentValue.trim();
						}	
					}
				}
				else if(bool_weekend)
				{
					if(bool_morning)
					{
						if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.TO))
						{
							Constant_Single.WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Morning.mTo=currentValue.trim();
						}
						else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.FROM))
						{
							Constant_Single.WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Morning.mFrom=currentValue.trim();
						}					
					}
					else if(bool_midday)
					{
						if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.TO))
						{
							Constant_Single.WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Midday.mTo=currentValue.trim();
						}
						else if(localName.equalsIgnoreCase(Constant_Single.WebService_Single_Tags.FROM))
						{
							Constant_Single.WebService_Single_Values.WebService_Single_Values_Time.WebService_Single_Values_Weekend.WebService_Single_Values_Midday.mFrom=currentValue.trim();
						}	
					}
				}				
			}			
			
			if (localName.equals(Constant_Single.WebService_Single_Tags.HSP))
			{				 
				bool_hsp=false;
			}
			else if (localName.equals(Constant_Single.WebService_Single_Tags.ADDRESS))
			{				 
				bool_address=false;
			}	
			else if (localName.equals(Constant_Single.WebService_Single_Tags.CONTANCT))
			{				 
				bool_contact=false;
			}	
			else if (localName.equals(Constant_Single.WebService_Single_Tags.TIME))
			{				 
				bool_time=false;
			}	
			else if (localName.equals(Constant_Single.WebService_Single_Tags.WEEK))
			{				 
				bool_week=false;
			}	
			else if (localName.equals(Constant_Single.WebService_Single_Tags.WEEKEND))
			{				 
				bool_weekend=false;
			}
			else if (localName.equals(Constant_Single.WebService_Single_Tags.MORNING))
			{				 
				bool_morning=false;
			}
			else if (localName.equals(Constant_Single.WebService_Single_Tags.MIDDAY))
			{				 
				bool_midday=false;
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
