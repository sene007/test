package hr.mamateam.fiscalbillchecker;

import hr.mamateam.fiscalbillchecker.sqlite.FiscalBillDataObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;
import java.sql.Date;

import org.apache.http.util.EncodingUtils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CheckBillWebActivity extends Activity {
	private final String URL = "http://www.provjeri-racun.hr/provjeraracuna";
	private WebView browser = null;
	private FiscalUtil util = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_bill_web);
		this.util = new FiscalUtil(this);
		
		initComponents();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_bill_web, menu);
		return true;
	}
	
	
	private void initComponents(){
		
		MyWebViewClient webClient = new MyWebViewClient();
		if (!webClient.isNetworkConnect()) {
			//TODO prikazati poruku iz Strings.xml
			this.finish(); //exit activity
		}
		
		
		browser = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = browser.getSettings();
		webSettings.setJavaScriptEnabled(true);  //enable javaScript
		webSettings.setBuiltInZoomControls(true);
		
		browser.setWebViewClient(new MyWebViewClient()); //disable loading default browser
		browser.loadUrl(URL); //load page
		browser.addJavascriptInterface(new MyJavaScriptInterface(this), "BillWebForm");
		
		
	}
	
	private class MyJavaScriptInterface {
		private Context con = null;
		
		/**
		 * Default constructor
		 */
		public MyJavaScriptInterface() {}
		
		public MyJavaScriptInterface(Context con) {
			this.con = con;
		}
		
		//TODO usefull methods for maintaining javascript functions
		
	}
	
	private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
        	return false;
        }
        
        

		@Override
		public void onPageFinished(WebView view, String url) {
//			super.onPageFinished(view, url);
			
//			browser.loadUrl("javascript:(function() { " +  
//                    "document.getElementById('vrijeme_sat').value = '12';" +
//                    "document.getElementById('datum').value = '18.03.2013';" +
//                    "document.getElementById('iznos_kn').value = '52';" +
//                    //"document.forms['form'].submit();" + //Doesn't Work
//                    //"document.getElementById('loginButton').click();" + //Doesn't Work
//                  "})()");
			
			setDataForTest();
			
			String temp = util.getWebFormWithValuesJavascript();
			browser.loadUrl(temp);
			String temp2 = "";
			
		}

		
		private void setDataForTest(){
			FiscalBillDataObject webForm = new FiscalBillDataObject();
			webForm.setJIR("8858db0c-f30e-4ef4-8928-18423f27a2cd");
			webForm.setCode("7abdf8ca62444261b5bf5cfc1dd3fb5");
			webForm.setCode("7abdf8ca62444261b5bf5cfc1dd3fb5");
			webForm.setBillDate(Date.valueOf("2013-03-16"));
			webForm.setBillHour(16);
			webForm.setBillMinute(42);
			webForm.setBillAmountKn(new BigDecimal(68));
			webForm.setBillAmountLp(new BigDecimal(35));
			
			util.setWebFormDataObject(webForm);
		}




		/**
		 * Method checks if System is connected to the Net.
		 * @return
		 */
		private boolean isNetworkConnect(){
			ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			
			NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
			if (activeInfo != null && activeInfo.isConnected()) {
				return true;
			} else return false;
		}
	}
	
	private class HttpHandler {
		private static final String DEBUG_TAG = "HttpHandler: ";
		private final String urlPath = "http://www.provjeri-racun.hr/provjeraracuna";
		
		/**
		 * Method checks if System is connected to the Net.
		 * @return
		 */
		private boolean isNetworkConnect(){
			ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			
			NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
			if (activeInfo != null && activeInfo.isConnected()) {
				return true;
			} else return false;
		}
		
		
		// Given a URL, establishes an HttpUrlConnection and retrieves
		// the web page content as a InputStream, which it returns as
		// a string.
		private String downloadUrl(String myurl) throws IOException {
		    InputStream is = null;
		        
		    try {
		        URL url = new URL(myurl);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setReadTimeout(10000); //10 sec
		        conn.setConnectTimeout(15000); //15 sec
		        conn.setRequestMethod("GET");
		        conn.setDoInput(true);
		        
		        conn.connect(); // Starts the query
		        int response = conn.getResponseCode();
		        Log.d(DEBUG_TAG, "The response is: " + response);
		        is = conn.getInputStream();

		        // Convert the InputStream into a string
		        String contentAsString = readStreamAsString(is);
		        return contentAsString;
		        
		    // close the InputStream
		    } finally {
		        if (is != null) {
		            is.close();
		        } 
		    }
		}
		
		// Reads an InputStream and converts it to a String.
		public String readStreamAsString(InputStream stream) throws IOException, UnsupportedEncodingException {
		    Reader reader = null;
		    reader = new InputStreamReader(stream, "UTF-8");        
		    String line = null;
		    
		    
		    
//		    char[] buffer = new char[len];
		    char[] buffer = new char[500];
		    reader.read(buffer);
		    return new String(buffer);
		}
		
		
	}
	

}
