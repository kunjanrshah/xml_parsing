package com.drc.webservicedataget;

import java.util.ArrayList;

/** Contains getter and setter method for varialbles  */
public class GetCategory_DataList {

	/** Variables */
	private ArrayList<String> mid = new ArrayList<String>();
	private ArrayList<String> mname = new ArrayList<String>();

	
	/** In Setter method default it will return arraylist 
	 *  change that to add  */
	
	public ArrayList<String> getID() {
		return mid;
	}

	public void setID(String id) {
		this.mid.add(id);
	}
	
	public ArrayList<String> getNAME() {
		return mname;
	}

	public void setNAME(String name) {
		this.mname.add(name);
	}
	
	//this method use for clear data
	public void ClearData(){
		mid.clear();
		mname.clear();
	}

}
