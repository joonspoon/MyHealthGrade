package org.wintriss.health.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);

	
	}
	
	public void loadSurveyPage(View view) {
		
		Intent intent = new Intent(this, SurveyActivity.class);
		
		startActivity(intent);
	}
}