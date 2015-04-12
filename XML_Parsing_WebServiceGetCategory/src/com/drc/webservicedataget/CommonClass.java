package com.drc.webservicedataget;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class CommonClass {
	private static final String strTAG="ServerConnection";
	
	private ConnectivityManager connectivity;
	private NetworkInfo netinfo;
//	public static boolean isDebug=false;
	/**This method use for check Network Connectivity
	 */
	public boolean CheckNetwork(Context mContext) {
		    this.connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
	        this.netinfo= connectivity.getActiveNetworkInfo();
	        if(netinfo!=null && netinfo.isConnected()==true)
	        {
	        	//Toast.makeText(this, "Connection Avilable", Toast.LENGTH_LONG).show();
	        	return true;
	        }
	        else
	        {
	        	makeAndShowDialogBox(mContext).show();
	        	return false;       	
	        }
		 
	}
	
	/**This method use for check Network Connectivity No Message
	 */
	public boolean CheckNetworkNoMessage(Context mContext) {
		    this.connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
	        this.netinfo= connectivity.getActiveNetworkInfo();
	        if(netinfo!=null && netinfo.isConnected()==true)
	        {
	        	return true;
	        }
	        else
	        {
	        	return false;       	
	        }
		
	}
	/************************************************************************************************/	
	private AlertDialog makeAndShowDialogBox(final Context mContext){
    	
        AlertDialog myQuittingDialogBox = 

        	new AlertDialog.Builder(mContext) 
        	//set message, title, and icon
        	.setTitle("PMK") 
//        	.setMessage(Constant.NETWORKNOT) 
        	.setCancelable(false)
        	//set three option buttons
        	.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
        		public void onClick(DialogInterface dialog, int whichButton) { 
            	 //whatever should be done when answering "YES" goes here
        			((Activity) mContext).finish();
        		}              
        	})//setPositiveButton
               	
        	.create();
        	
        	return myQuittingDialogBox;
    }
	/************************************************************************************************/
	/**This method use for PostConnection to Server
	 */
	public String PostConnection(String strUrl,ArrayList<NameValuePair> alstNameValuePair) {
		InputStream mInputStream = null;
		try {
			//This is the default apacheconnection.
			HttpClient mHttpClient = new DefaultHttpClient();
			
			//Pathe of serverside 
			HttpPost mHttpPost = new HttpPost(strUrl);
			
			if(alstNameValuePair!=null)
			{ 
				//post the valur you want to pass.
				 mHttpPost.setEntity(new UrlEncodedFormEntity(alstNameValuePair));
			}
			
			//get the valu from the saerverside as response.
			HttpResponse mHttpResponse = mHttpClient.execute(mHttpPost);
			HttpEntity mHttpEntity = mHttpResponse.getEntity();
			mInputStream = mHttpEntity.getContent();
		
		  } 
		  catch (Exception e) {
			 // TODO Auto-generated catch block
			 Log.e(strTAG,"Error in HttpClient,HttpPost,HttpResponse,HttpEntity");
		  }
		
		 String strLine = null;
		 String strResult = null;
		//convert response in to the string.
		try {
			  BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(mInputStream,"ISO-8859-1"), 8);
			  StringBuilder mStringBuilder = new StringBuilder();
		  	  while((strLine = mBufferedReader.readLine()) != null) {
		  		mStringBuilder.append(strLine + "\n");
			  }
		  	  mInputStream.close();
		  	  strResult = mStringBuilder.toString();			
		   } 
		   catch (Exception e) {
			  //System.out.println("Error in BufferedReadering");
		      Log.e(strTAG,"Error in BufferedReadering");
		    }
		
		 return strResult;
	}
	
	
	/**This method get InputStream use for PostConnectionInputStream to Server
	 */
	public InputStream PostConnectionInputStream(String strUrl,ArrayList<NameValuePair> alstNameValuePair) {
		try {
			//This is the default apacheconnection.
			HttpClient mHttpClient = new DefaultHttpClient();
			
			//Pathe of serverside 
			HttpPost mHttpPost = new HttpPost(strUrl);
			
			if(alstNameValuePair!=null)
			{ 
				//post the valur you want to pass.
				 mHttpPost.setEntity(new UrlEncodedFormEntity(alstNameValuePair));
			}
			
			//get the valu from the saerverside as response.
			HttpResponse mHttpResponse = mHttpClient.execute(mHttpPost);
			HttpEntity mHttpEntity = mHttpResponse.getEntity();
			return mHttpEntity.getContent();
		  } 
		  catch (Exception e) {
			 // TODO Auto-generated catch block
			 Log.e(strTAG,"Error in HttpClient,HttpPost,HttpResponse,HttpEntity");
			 return null;
		  }
		
	}
	
	/**This method use for GetConnection to Server
	 */
	public String GetConnection(String strUrl) {
		InputStream mInputStream = null;
		try {
			//This is the default apacheconnection.
			HttpClient mHttpClient = new DefaultHttpClient();		
			//Pathe of serverside 
			HttpGet mHttpGet = new HttpGet(strUrl);
			
			//get the valu from the saerverside as response.
			HttpResponse mHttpResponse = mHttpClient.execute(mHttpGet);
			HttpEntity mHttpEntity = mHttpResponse.getEntity();
			mInputStream = mHttpEntity.getContent();
		
		  } 
		  catch (Exception e) {
			 // TODO Auto-generated catch block
			 Log.e(strTAG,"Error in HttpClient,HttpPost,HttpResponse,HttpEntity");
		  }
		
		 String strLine = null;
		 String strResult = null;
		//convert response in to the string.
		try {
			  BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(mInputStream,"ISO-8859-1"), 8);
			  StringBuilder mStringBuilder = new StringBuilder();
		  	  while((strLine = mBufferedReader.readLine()) != null) {
		  		mStringBuilder.append(strLine + "\n");
			  }
		  	  mInputStream.close();
		  	  strResult = mStringBuilder.toString();			
		   } 
		   catch (Exception e) {
			  //System.out.println("Error in BufferedReadering");
		      Log.e(strTAG,"Error in BufferedReadering");
		    }
		   
		return strResult;		   
	}
	
	/**This method get InputStream use for GetConnectionInputStream to Server
	 */
	public InputStream GetConnectionInputStream(String strUrl) {
		try {
			//This is the default apacheconnection.
			HttpClient mHttpClient = new DefaultHttpClient();		
			//Pathe of serverside 
			HttpGet mHttpGet = new HttpGet(strUrl);
			
			//get the valu from the saerverside as response.
			HttpResponse mHttpResponse = mHttpClient.execute(mHttpGet);
			HttpEntity mHttpEntity = mHttpResponse.getEntity();
			return mHttpEntity.getContent();
		
		  } 
		  catch (Exception e) {
			 Log.e(strTAG,"Error in HttpClient,HttpPost,HttpResponse,HttpEntity");
			 return null;
		  }	   
	}
	
	
	public String InputStreamToString(InputStream mInputStream){
		 String strLine = null;
		//convert response in to the string.
		try {
			  BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(mInputStream,"ISO-8859-1"), 8);
			  StringBuilder mStringBuilder = new StringBuilder();
		  	  while((strLine = mBufferedReader.readLine()) != null) {
		  		mStringBuilder.append(strLine);
			  }
		  	  mInputStream.close();
		  	  return mStringBuilder.toString();			
		   } 
		   catch (Exception e) {
			  //System.out.println("Error in BufferedReadering");
		      Log.e(strTAG,"Error in BufferedReadering");
		      return null;
		  }
	}
	
	 /**This method use to Check Memory Card
	 */  
    public Boolean MemoryCardCheck() {
		
    	if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
	}
}
