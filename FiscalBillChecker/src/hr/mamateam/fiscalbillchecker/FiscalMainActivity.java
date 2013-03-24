package hr.mamateam.fiscalbillchecker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FiscalMainActivity extends Activity implements OnClickListener {
	private Button but_takePic = null;
	private Button but_webForm = null;
	private Button but_history = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fiscal_main);
		
		//TODO async Task za sql lite bazu
		//TODO async Task za http klijenta
		
		
		//TODO button za podizanje activitya za slikanje racuna 
		initComponents();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fiscal_main, menu);
		return true;
	}

	/**
	 * Method is used to initialize screen view and widgets.
	 */
	private void initComponents (){
		this.but_takePic = (Button) findViewById(R.id.but_takePicture);
		but_takePic.setOnClickListener(this);
		
		this.but_webForm = (Button) findViewById(R.id.but_webForm);
		but_webForm.setOnClickListener(this);
		
		this.but_history = (Button) findViewById(R.id.but_webFormHistory);
		but_history.setOnClickListener(this);
	}
	
	
	
	//TODO
	private void initDataBase() {
		
	}
	
	//TODO
	private void initWebClient() {
		
	}

	@Override
	public void onClick(View view) {
		if (view == this.but_takePic){
			//call take picture activity
			Intent pictureIntent = new Intent ("hr.mamateam.fiscalbillchecker.PICTURE");
			startActivity(pictureIntent);
//			startActivityForResult(intent, requestCode); //TODO povratni reqCode kao procitani text racuna
		}
		
		if (view == this.but_webForm){
			Intent webFormIntent = new Intent ("hr.mamateam.fiscalbillchecker.WEB");
			startActivity(webFormIntent);
		}
		
		if (view == this.but_history){
			Intent webFormHistoryIntent = new Intent ("hr.mamateam.fiscalbillchecker.HISTORY");
			startActivity(webFormHistoryIntent);
		}
		
	}
	
	
	
}
