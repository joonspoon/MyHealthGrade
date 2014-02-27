package org.wintriss.health.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PrescriptionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prescription);

		TextView exerciseView = (TextView) findViewById(R.id.exerciseView);
		TextView dietView = (TextView) findViewById(R.id.dietView);
		TextView smokeView = (TextView) findViewById(R.id.smokeView);
		
//
//		TextView smokeView = new TextView(this);
//		exerciseView.setTextSize(20);
//		exerciseView.setText(R.string.smoking_prescription);
//
//		TextView dietView = new TextView(this);
//		dietView.setTextSize(20);
//		dietView.setText(R.string.diet_prescription);

		Intent intent = getIntent();
		boolean exercise = intent.getBooleanExtra(SurveyActivity.EXERCISE, false);
		boolean smoke = intent.getBooleanExtra(SurveyActivity.SMOKE, false);
		boolean diet = intent.getBooleanExtra(SurveyActivity.DIET, false);
		boolean fastFood = intent.getBooleanExtra(SurveyActivity.FAST_FOOD, false);
		boolean overweight = intent.getBooleanExtra(SurveyActivity.OVERWEIGHT, false);

		// Create the text view
		// TextView textView = new TextView(this);
		//
		// textView.setText("exercise? " + exercise);
		// setContentView(textView);
//		exerciseView.setVisibility(View.INVISIBLE);
//		dietView.setVisibility(View.INVISIBLE);
//		smokeView.setVisibility(View.INVISIBLE);
//		
		if (!exercise || overweight) {
			exerciseView.setText(R.string.get_more_exercise);
		}
		if (!diet || fastFood)
			dietView.setText(R.string.diet_prescription);
		if (smoke)
			smokeView.setText(R.string.smoking_prescription);

	}
}