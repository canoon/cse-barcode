package com.shptech.scanner;

import java.util.Arrays;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UNSWStudentIdScannerActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		IntentIntegrator integrator = new IntentIntegrator(this);
		String[] codes = {"CODE_39"};
		integrator.initiateScan(Arrays.asList(codes));
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    	  if (scanResult != null) {
    		  TextView tv = (TextView) findViewById(R.id.text);
    		  tv.setText(scanResult.getContents());
    	  }
    }
}