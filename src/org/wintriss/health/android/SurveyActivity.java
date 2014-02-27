package org.wintriss.health.android;

import java.io.IOException;
import java.io.InputStream;

import org.wintriss.health.calculator.HealthMeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SurveyActivity extends Activity {

	public static final String LOCATION = "location";
	public static final String EXERCISE = "exercise";
	public static final String SMOKE = "smoke";
	public static final String DIET = "diet";
	public static final String FAST_FOOD = "fast_food";
	public static final String OVERWEIGHT = "overweight";

	private ImageView gradeImage;
	private InputStream excelFile;
	HealthMeter healthMeter;
	TextView result;
	Spinner locationSelector;

	private boolean exercise;
	private boolean fastFood;
	private boolean smoke;
	private boolean overweight;
	private boolean diet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.survey);

		gradeImage = (ImageView) findViewById(R.id.imageView1);
		locationSelector = (Spinner) findViewById(R.id.spinner1);
		result = (TextView) findViewById(R.id.textView1);

		locationSelector.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				updateResult();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		try {
			this.excelFile = getAssets().open("BehaviourData.xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		healthMeter = new HealthMeter(excelFile);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void updateResult() {
		String theVerdict = healthMeter.compareScores(locationSelector.getSelectedItem().toString());
		result.setText(theVerdict);

		drawPic(theVerdict);

	}

	public void onCheckboxClicked(View view) {

		boolean wasChecked = ((CheckBox) view).isChecked();

		// Check which checkbox was clicked
		switch (view.getId()) {
		case R.id.checkbox_exercise:
			if (wasChecked) {
				healthMeter.setExercise(0);
				this.exercise = true;
			} else {
				healthMeter.setExercise(1);
				this.exercise = false;
			}
			break;
		case R.id.checkbox_diet:
			if (wasChecked) {
				healthMeter.setDiet(0);
				this.diet = true;
			} else {
				healthMeter.setDiet(1);
				this.diet = false;
			}
			break;
		case R.id.checkbox_fastfood:
			if (wasChecked) {
				healthMeter.setFastFood(1);
				this.fastFood = true;
			} else {
				healthMeter.setFastFood(0);
				this.fastFood = false;
			}
			break;
		case R.id.checkbox_overweight:
			if (wasChecked) {
				healthMeter.setObese(1);
				this.overweight = true;
			} else {
				healthMeter.setObese(0);
				this.overweight = false;
			}
			break;
		case R.id.checkbox_smoke:
			if (wasChecked) {
				this.smoke = true;
				healthMeter.setSmoke(1);
			} else {
				healthMeter.setSmoke(0);
				this.smoke = false;
			}
			break;
		}

		updateResult();
	}

	private void drawPic(String verdict) {
		if (verdict.contains("higher"))
			gradeImage.setImageResource(R.drawable.healthpic);
		else
			gradeImage.setImageResource(R.drawable.unhealthy);

		gradeImage.setVisibility(View.VISIBLE);
	}

	public void loadCommunityPage(View view) {

		Intent intent = new Intent(this, CommunityActivity.class);
		intent.putExtra(LOCATION, locationSelector.getSelectedItem().toString());
		startActivity(intent);
	}

	public void loadPrescriptionPage(View view) {

		Intent intent = new Intent(this, PrescriptionActivity.class);
		intent.putExtra(EXERCISE, exercise);
		intent.putExtra(FAST_FOOD, fastFood);
		intent.putExtra(SMOKE, smoke);
		intent.putExtra(DIET, diet);
		intent.putExtra(OVERWEIGHT, overweight);
		startActivity(intent);
	}

}
