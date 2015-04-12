package com.drc.webservicedataget;

import java.io.StringReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import android.app.Activity;
import android.os.Bundle;

public class WebServiceDataGetActivity extends Activity {
	private GetCategory_DataList mGetCategory_DataList = null;
	private CommonClass mCommonClass=new CommonClass();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        if(mCommonClass.CheckNetwork(this)){

			String Response = mCommonClass.GetConnection(Constant.CATEGORY_URL);
			if(Response!=null){
		        	System.out.println("Response " + Response);
					try {					
							/** Handling XML */
							SAXParserFactory mSAXParserFactory = SAXParserFactory.newInstance();
							SAXParser mSAXParser = mSAXParserFactory.newSAXParser();
							XMLReader mXMLReader = mSAXParser.getXMLReader();
				
							/** Create handler to handle XML Tags ( extends DefaultHandler ) */
							GetCategory_XMLHandler mGetCategory_XMLHandler = new GetCategory_XMLHandler();
							mXMLReader.setContentHandler(mGetCategory_XMLHandler);

							InputSource mInputSource = new InputSource(new StringReader(Response));
							mXMLReader.parse(mInputSource);

					   } catch (Exception e) {
						   e.printStackTrace();
					   }
					/** Get result from MyXMLHandler SitlesList Object */
				    mGetCategory_DataList = GetCategory_XMLHandler.getCategoryList();
					if(mGetCategory_DataList!=null){
						for (int i = 0; i < mGetCategory_DataList.getID().size(); i++) {
							System.out.println((i+1) +" ID = " + mGetCategory_DataList.getID().get(i).toString());
							System.out.println((i+1) +" NAME = " + mGetCategory_DataList.getNAME().get(i).toString());
						}
					}
			}
        }
    }
}