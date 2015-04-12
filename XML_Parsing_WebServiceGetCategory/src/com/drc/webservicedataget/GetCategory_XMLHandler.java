package com.drc.webservicedataget;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetCategory_XMLHandler extends DefaultHandler {

	Boolean currentElement = false;
	String currentValue = null;
	public static GetCategory_DataList mGetCategory_DataList = null;

	public static GetCategory_DataList getCategoryList() {
		return mGetCategory_DataList;
	}

	public static void setCategoryList(GetCategory_DataList mGetCategory_DataList) {
		GetCategory_XMLHandler.mGetCategory_DataList = mGetCategory_DataList;
	}

	/** Called when tag starts ( ex:- <name>AndroidPeople</name> 
	 * -- <name> )*/
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		currentElement = true;
        currentValue="";
		if (localName.equals(Constant.ITEMS))
		{
			/** Start */ 
			mGetCategory_DataList = new GetCategory_DataList();
			mGetCategory_DataList.ClearData();
		}
	}

	/** Called when tag closing ( ex:- <name>AndroidPeople</name> 
	 * -- </name> )*/
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		currentElement = false;
		
		if (localName.equalsIgnoreCase(Constant.ID))
		{
			if(currentValue!=null){
				mGetCategory_DataList.setID(currentValue);
//				System.out.println("ID " +currentValue);
			}
		}
		if(localName.equalsIgnoreCase(Constant.NAME))
		{   
			if(currentValue!=null){
				mGetCategory_DataList.setNAME(currentValue);
//				System.out.println("NAME " +currentValue);
			}
		}			
	}

	/** Called to get tag characters ( ex:- <name>AndroidPeople</name> 
	 * -- to get AndroidPeople Character ) */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (currentElement) {
			currentValue = new String(ch, start, length);
			currentElement = false;
		}

	}

}
