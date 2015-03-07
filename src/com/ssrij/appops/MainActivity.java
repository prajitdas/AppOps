package com.ssrij.appops;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.android.settings.applications.AppOpsSummary;

public class MainActivity extends PreferenceActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final AppOpsManager mAppOps = (AppOpsManager) this.getSystemService(Context.APP_OPS_SERVICE);

		//Setting hardcoded permissions
		mAppOps.setMode(AppOpsManager.OP_COARSE_LOCATION, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_FINE_LOCATION, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_GPS, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_WIFI_SCAN, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_NEIGHBORING_CELLS, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_WAKE_LOCK, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_MONITOR_LOCATION, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_MONITOR_HIGH_POWER_LOCATION, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_CAMERA, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		mAppOps.setMode(AppOpsManager.OP_CALL_PHONE, 10123, "com.facebook.katana", AppOpsManager.MODE_IGNORED);
		
		if (savedInstanceState == null) {
		 AppOpsSummary appopssummary = new AppOpsSummary();
         appopssummary.setArguments(getIntent().getExtras());
         getFragmentManager().beginTransaction().add(0x1020002, appopssummary).commit();
	} }
	
	@Override
    protected boolean isValidFragment (String fragmentName) { return true; }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.about:
	        	ShowAbout();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@SuppressWarnings("deprecation")
	public void ShowAbout() {
        AlertDialog alertDialog1 = new AlertDialog.Builder(this).create();
        alertDialog1.setTitle("About");
        alertDialog1.setMessage("AppOps AOSP port\nCreated by: Suyash Srijan\nsuyashsrijan@outlook.com");
        alertDialog1.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) { } });
        alertDialog1.show();
	}
}


