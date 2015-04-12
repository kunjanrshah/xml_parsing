package com.hella.xmlread;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Debug;
import android.os.Environment;
import android.text.Html;
import android.text.Spanned;
import android.widget.Toast;

/**
 *@author  DRCSystems
 *@version 1.1
 *@class   Utility
 *@date    5/5/2012
 *Utility class use for global use
 */
public class Utility {
	
	/**This method use for check Network Connectivity
	 * @param
	 * @return  boolean
	 */
	public static boolean CheckNetwork(Context mContext) {
		    ConnectivityManager connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		    NetworkInfo netinfo= connectivity.getActiveNetworkInfo();
	        if(netinfo!=null && netinfo.isConnected()==true){
	        	return true;
	        }
	        else{
	        	return false;       	
	        }
	}
	
	/**This method use for GetConnection InputStream to Server
	 * @param 
	 * @return InputStream
	 */
	public static InputStream GetConnectionInputStream(String strUrl) {
		try {
			//This is the default apacheconnection.
			HttpClient mHttpClient = new DefaultHttpClient();
			
			//Pathe of serverside 
			HttpGet mHttpGet = new HttpGet(strUrl);
			
			//get the valu from the saerverside as response.
			HttpResponse mHttpResponse = mHttpClient.execute(mHttpGet);
			HttpEntity mHttpEntity = mHttpResponse.getEntity();
			return (InputStream)mHttpEntity.getContent();
		  } 
		  catch (Exception e) {
			 e.printStackTrace();
			 return null;
		  }
		
	}
	
	/**This method use for InputStream To String Convert
	 * @param
	 * @return  String
	 */
	public static String InputStreamToString(InputStream mInputStream){
		//convert response in to the string.
		try {
			  if(mInputStream!=null){
				  String strLine = "";
				  BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(mInputStream,HTTP.UTF_8), 8);
				  StringBuilder mStringBuilder = new StringBuilder();
			  	  while((strLine = mBufferedReader.readLine()) != null) {
			  		mStringBuilder.append(strLine);
				  }
			  	  
			  	  return mStringBuilder.toString();			
			  }
			  else{
				  return null;
			  }
		   } 
		   catch (Exception e) {
			   	e.printStackTrace();
			   	return null;
		  }
		finally{
			closeSilently(mInputStream);
		}
	}
	
   /**This method use to Check Memory Card
    * @return Boolean
    */  
    public static Boolean MemoryCardCheck() {	
    	if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
    		return true;
    	}
    	else{
    		return false;
    	}
	}
    
    /**This method use to get filelist from folder
     * @param Folder_Path for string folderpath
     * @return ArrayList<String>
	 */ 
    public static ArrayList<String> FileList(String Folder_Path) {
    	    ArrayList<String> mArrayList=new ArrayList<String>();
    	    mArrayList.clear();
    	    try{
        	    if(new File(Folder_Path).exists()){
       	    	 File dir = new File(Folder_Path);
       	    	    File[] filelist = dir.listFiles();
       	    	    for (File f : filelist)
       	    	    { 
       	    	    	if(Check_Supported_File(f.getName().toString())){
       	    	    		mArrayList.add(f.getPath().toString());
       	    	    	}
       	    	    }
       	        }
    	    }
    	    catch (Exception e) {
				e.printStackTrace();
			}
    	    return mArrayList;
	}
    
    /**This method use to check supported file extension
     * @param FileName string file path
     * @return boolean
	 */  
    private static boolean Check_Supported_File(String FileName){
    	  try{
    		  String File_Extension=FileName.substring(FileName.lastIndexOf(".")+1,FileName.length()).toLowerCase(); 

    		  if(File_Extension.equals("jpg")||File_Extension.equals("jpeg")){
    			  return true; 
    		  }
    		  else{
    			  return false; 
    		  }
    	  }
    	  catch (Exception e) {
			 e.printStackTrace();
			 return false; 
		  }
    	 
    }
    
//	 /**This function use for get Drawable from Sdcard
//	  * @param ImagePath for string image path
//	  * @param context current activity reference
//	  * @param Width for image width set
//	  * @param Height for image height set
//	  * @return Drawable
//	  */
//    public static Drawable DecodeFileGetDrawable(String ImagePath,Context context,int Width,int Height){
//   	     try{     	
//   	    	 	 File mFile=new File(ImagePath);
//				 if(mFile.exists()){
//					 
//		           	 BitmapFactory.Options mBitmapFactoryOptions = new BitmapFactory.Options();
//		             mBitmapFactoryOptions.inJustDecodeBounds=true;
//		             BitmapFactory.decodeFile(ImagePath, mBitmapFactoryOptions);
//		  
//		            if (CheckBitmapFitsInMemory(mBitmapFactoryOptions.outWidth, mBitmapFactoryOptions.outHeight, 2)){
////		                   Log.i(Constant.TAG,"Aborting bitmap load for avoiding memory crash");
//		
//				    		  // Decode the image file into a Bitmap sized to fill the View
//		                     mBitmapFactoryOptions.inJustDecodeBounds = false;
//		                     mBitmapFactoryOptions.inPurgeable = true;
//			    		     
//		            	    return new BitmapDrawable(Image_Shrink(BitmapFactory.decodeStream(new FileInputStream(mFile),null,mBitmapFactoryOptions),Width,Height));
//		            }
//		            else{
//		           	    Log.w(Constant.TAG,"Bitmap Load Memory Crash.");
//		           	    return context.getResources().getDrawable(R.drawable.img_loading);
//		            }
//				 }
//   	    	     else{
//	   	    	    	 Log.w(Constant.TAG,"ImagePath Not Found.");
//	   	    	    	 return context.getResources().getDrawable(R.drawable.img_loading);
//   	    	     }
//				 
//
//	    		
//   	 		} 
//   	     catch (Exception e) {
//	   	    	 e.printStackTrace();
//	   	    	 return context.getResources().getDrawable(R.drawable.img_loading);
//   	     }
//    }
    
    /**This function use for get Bitmap from Sdcard
	  * @param ImagePath for string image path
	  * @param context Application or current activity reference
	  *@param Width for image width set
	  *@param Height for image height set
	  * @return Bitmap
	  */
//   public static Bitmap DecodeFileGetBitmap(String ImagePath,Context context,int Width,int Height){
//  	     try{     	
//  	    	 	 File mFile=new File(ImagePath);
//				 if(mFile.exists()){
//					 
//		           	 BitmapFactory.Options mBitmapFactoryOptions = new BitmapFactory.Options();
//		             mBitmapFactoryOptions.inJustDecodeBounds=true;
//		             BitmapFactory.decodeFile(ImagePath, mBitmapFactoryOptions);
//		  
//		            if (CheckBitmapFitsInMemory(mBitmapFactoryOptions.outWidth, mBitmapFactoryOptions.outHeight, 2)){
////		                   Log.i(Constant.TAG,"Aborting bitmap load for avoiding memory crash");
//		
//				    		  // Decode the image file into a Bitmap sized to fill the View
//		                     mBitmapFactoryOptions.inJustDecodeBounds = false;
//		                     mBitmapFactoryOptions.inPurgeable = true;
//			    		     
//		            	    return Image_Shrink(BitmapFactory.decodeStream(new FileInputStream(mFile),null,mBitmapFactoryOptions),Width,Height);
//		            }
//		            else{
//		           	    Log.w(Constant.TAG,"Bitmap Load Memory Crash.");
//		           	    return  BitmapFactory.decodeResource(context.getResources(), R.drawable.img_loading);
//		            }
//				 }
//  	    	     else{
//	   	    	    	 Log.w(Constant.TAG,"ImagePath Not Found.");
//	   	    	    	 return  BitmapFactory.decodeResource(context.getResources(), R.drawable.img_loading);
//  	    	     }
//				 
//
//	    		
//  	 		} 
//  	     catch (Exception e) {
//	   	    	 e.printStackTrace();
//	   	    	 return  BitmapFactory.decodeResource(context.getResources(), R.drawable.img_loading);
//  	     }
//   }
   
//   /**This function use for get Bitmap from id
//	  * @param image_id for image resource id
//	  * @param context current activity reference
//	  *@param Width for image width set
//	  *@param Height for image height set
//	  * @return Bitmap
//	  */
// public static Bitmap DecodeResourceGetBitmap(int image_id,Context context,int Width,int Height){
//	     try{     	
//					 
//		           	 BitmapFactory.Options mBitmapFactoryOptions = new BitmapFactory.Options();
//		             mBitmapFactoryOptions.inJustDecodeBounds=true;
//		             BitmapFactory.decodeResource(context.getResources(), image_id,mBitmapFactoryOptions);
//		            if (CheckBitmapFitsInMemory(mBitmapFactoryOptions.outWidth, mBitmapFactoryOptions.outHeight, 2)){
////		                   Log.i(Constant.TAG,"Aborting bitmap load for avoiding memory crash");
//		
//				    		  // Decode the image file into a Bitmap sized to fill the View
//		                     mBitmapFactoryOptions.inJustDecodeBounds = false;
//		                     mBitmapFactoryOptions.inPurgeable = true;
//			    		     
//		            	    return Image_Shrink(BitmapFactory.decodeResource(context.getResources(),image_id,mBitmapFactoryOptions),Width,Height);
//		            }
//		            else{
//		           	    Log.w(Constant.TAG,"Bitmap Load Memory Crash.");
//		           	    return  BitmapFactory.decodeResource(context.getResources(), R.drawable.img_loading);
//		            }
//	 		} 
//	     catch (Exception e) {
//	   	    	 e.printStackTrace();
//	   	    	 return  BitmapFactory.decodeResource(context.getResources(), R.drawable.img_loading);
//	     }
// }
    
    /**This function use for big image to make small
     *@param 
     *@param Width for image width set
	 *@param Height for image height set
     *@return Bitmap
     * */
    private static Bitmap Image_Shrink(Bitmap BitmapPreScale,int Width,int Height){
    	
    	if(BitmapPreScale!=null){
    		try{
    			int oldWidth = BitmapPreScale.getWidth();
        		int oldHeight = BitmapPreScale.getHeight();
        		int newWidth = Width;  // whatever your desired width and height are
        		int newHeight = Height;

        		// calculate the scale
        		float scaleWidth = ((float) newWidth) / oldWidth;
        		float scaleHeight = ((float) newHeight) / oldHeight;

        		// create a matrix for the manipulation
        		Matrix matrix = new Matrix();
        		// resize the bit map
        		matrix.postScale(scaleWidth, scaleHeight);

        		// recreate the new Bitmap
        		return Bitmap.createBitmap(BitmapPreScale, 0, 0,  oldWidth, oldHeight, matrix, true);
    		}
    		catch (Exception e) {
				e.printStackTrace();
				return null;
			}
    		finally{
    			if(BitmapPreScale!=null){
    				if(!BitmapPreScale.isRecycled()){
    					BitmapPreScale.recycle();
    					Utility.GC();
        			}
    			}
    			
    		}	
    	}
    	else{
    		return null;
    	}
    	
    }
  
  /**This function use for check Native free memory and store bitmap
   * @param 
   * @return boolean
   * */
  private static boolean CheckBitmapFitsInMemory(long bmpwidth,long bmpheight, int bmpdensity ){
      long reqsize=bmpwidth*bmpheight*bmpdensity;
      long allocNativeHeap = Debug.getNativeHeapAllocatedSize();


      final long heapPad=(long) Math.max(4*1024*1024,Runtime.getRuntime().maxMemory()*0.1);
      if ((reqsize + allocNativeHeap + heapPad) >= Runtime.getRuntime().maxMemory())
      {
          return false;
      }
      return true;
  }
    
	/**This function use for delete image file from memory card
	  * @param ImagePath for string image path
	  * @param context application or activity reference
	  * @return void
	  */
//    public static boolean Delete_File(String ImagePath,Context context){
//    	 try{     	
//	    	 	 File mFile=new File(ImagePath);
//	    	 	 if(mFile.exists()){
//	    	 		 if(mFile.delete()){
//	    	 			 Show_Short_Toast(context, Constant.DELETE.DELETE_MESSAGE_YES);
//		    	 		 return true;
//	    	 		 }
//	    	 		 else{
//	    	 			Log.w(Constant.TAG,"Image Not Delete.");
//	    	 			 return false;
//	    	 		 }
//	    	 	 }
//	    	     else{
//   	    	    	 Log.w(Constant.TAG,"ImagePath Not Found.");
//   	    	    	 return false;
//	    	     }
//	 		} 
//	     catch (Exception e) {
//   	    	 e.printStackTrace();
//   	    	 return false;
//	     }
//    }
    
    /**This method for setDINPro Black Font set
     * @param
     * @return Typeface
	 */ 
	public static Typeface setDINPro_Black_Font(Resources mResources){
		return Typeface.createFromAsset(mResources.getAssets(),"fonts/DINPro_Black.ttf");
	}
	
    /**This method for setDINPro Bold Font set
     * @param
     * @return Typeface
	 */ 
	public static Typeface setDINPro_Bold_Font(Resources mResources){
		return Typeface.createFromAsset(mResources.getAssets(),"fonts/DINPro_Bold.ttf");
	}
	
    /**This method for setDINPro Light Font set
     * @param
     * @return Typeface
	 */ 
	public static Typeface setDINPro_Light_Font(Resources mResources){
		return Typeface.createFromAsset(mResources.getAssets(),"fonts/DINPro_Light.ttf");
	}
	
    /**This method for setDINPro Medium Font set
     * @param
     * @return Typeface
	 */ 
	public static Typeface setDINPro_Medium_Font(Resources mResources){
		return Typeface.createFromAsset(mResources.getAssets(),"fonts/DINPro_Medium.ttf");
	}
	
    /**This method for setDINPro Regular Font set
     * @param
     * @return Typeface
	 */ 
	public static Typeface setDINPro_Regular_Font(Resources mResources){
		return Typeface.createFromAsset(mResources.getAssets(),"fonts/DINPro_Regular.ttf");
	}
	
    /**This method for Show Short Toast Message
     * @param
     * @return void
	 */ 
	public static void Show_Short_Toast(Context context,CharSequence Message){
		Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
	}
	
    /**This method for Show Long Toast Message
     * @param
     * @return void
	 */ 
	public static void Show_Long_Toast(Context context,CharSequence Message){
		Toast.makeText(context, Message, Toast.LENGTH_LONG).show();
	}
	
    /**This method for Text write in Bold and Normal style
     * @param
     * @return Spanned
	 */ 
	public static Spanned Bold_Normal_Text(String bold,String divider,String normal) {
		 return Html.fromHtml(String.format("<b>%s</b>%s%s", bold,divider,normal).toString());
	}
	
    /**This method for Text write in Normal and Bold style
     * @param
     * @return Spanned
	 */ 
	public static Spanned Normal_Bold_Text(String normal,String divider,String bold) {
		 return Html.fromHtml(String.format("%s%s<b>%s</b>", normal,divider,bold).toString());
	}
	
//    /**This method for Alert_Dialog
//     * @param context refrence of application
//     * @param Message stings of message display
//     * @return void
//	 */ 
//	public static void Alert_Dialog(Context context,String Message){
//		   AlertDialog.Builder mAlertDialogBuilder = new AlertDialog.Builder(context);
////			// set title
////		   mAlertDialogBuilder.setTitle("Your Title");
//		   // set dialog message
//		   mAlertDialogBuilder
//				.setMessage(Message)
//				.setCancelable(false)
//				.setPositiveButton(Constant.ALERTDIALOG_BUTTON.OK,new DialogInterface.OnClickListener() {
//						public void onClick(DialogInterface dialog,int id) {
//							dialog.cancel();
//						}
//				  });
// 
//				// create alert dialog
//				AlertDialog mAlertDialog = mAlertDialogBuilder.create();
//				mAlertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//				mAlertDialog.setCancelable(false);
//				mAlertDialog.setCanceledOnTouchOutside(false);
//				// show it
//		        mAlertDialog.show();
//	}
	
	
  /**This method for Alert_Message_Dialog
  * @param context refrence of application
  * @param Message stings of message display
  * @return void
	 */ 
//	public static void Alert_Message_Dialog(final Context context,String Message){
//		final Dialog mDialog = new Dialog(context);
//		mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		mDialog.setContentView(R.layout.xalert_cust);
//		mDialog.setCancelable(false);
//		mDialog.setCanceledOnTouchOutside(false);
//		mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
//		
//		final LinearLayout llay_dialog=(LinearLayout)mDialog.findViewById(R.id.llay_dialog);
//		TextView txt_alert_message = (TextView)mDialog.findViewById(R.id.txt_alert_message);
//		txt_alert_message.setText(Message);
//		
//		Button btn_alert_ok = (Button)mDialog.findViewById(R.id.btn_alert_ok);
//		btn_alert_ok.setText(Constant.ALERTDIALOG_BUTTON.OK);
//		btn_alert_ok.setOnClickListener(new OnClickListener() {
//			
//			public void onClick(View v) {
//				mDialog.dismiss();
//			}
//		});
//		
//		mDialog.show();
//		
//		llay_dialog.post(new Runnable() {
//			@Override
//			public void run() {
//				llay_dialog.setAnimation(AnimationUtils.loadAnimation(context, R.anim.alert_dialog));
//			}
//		});
//	}
		
	/**This method for close object
	 * @param context for application refrence
	 * @param FileName string for image assets path
     * @return Bitmap
	 */
	public static Bitmap getBitmapFromAssets(Context context,String FileName)
    {
    	InputStream mInputStream=null;
    	try{
	            mInputStream = context.getAssets().open(FileName);
	            return BitmapFactory.decodeStream(mInputStream);
    	}
    	catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	finally{
    		closeSilently(mInputStream);
    	}
    }
	
	/**This method for close object
     * @return void
	 */ 
    public static void closeSilently(Closeable c) {
        if (c == null)
            return;
        try {
            c.close();
        } catch (Throwable t) {
            // do nothing
        }
    }
	
    /**This method for Garbase collection
     * @return void
	 */ 
	public static void GC(){
		System.gc();
		System.runFinalization();
	}

}
