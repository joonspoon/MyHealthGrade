package org.wintriss.health.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CommunityActivity extends Activity {

	private ImageView pieChart;

	private TextView communityInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.community);

		Intent intent = getIntent();
		String location = intent.getStringExtra(SurveyActivity.LOCATION)
				.toLowerCase();

		pieChart = (ImageView) findViewById(R.id.pieChartView);
		int pieImageNumber = 0;
		if (location.equals("alpine"))
			pieImageNumber = R.drawable.alpine;
		else if (location.equals("central sd"))
			pieImageNumber = R.drawable.central_sd;
		else if (location.equals("chula vista"))
			pieImageNumber = R.drawable.chula_vista;
		else if (location.equals("coronado"))
			pieImageNumber = R.drawable.coronado;
		else if (location.equals("del mar-mira mesa"))
			pieImageNumber = R.drawable.del_mar_mira_mesa;
		else if (location.equals("la mesa"))
			pieImageNumber = R.drawable.la_mesa;
		else if (location.equals("poway"))
			pieImageNumber = R.drawable.poway;
		else if (location.equals("santee"))
			pieImageNumber = R.drawable.santee;
		else if (location.equals("southeast sd"))
			pieImageNumber = R.drawable.south_east_sd;
		else if (location.equals("university"))
			pieImageNumber = R.drawable.university;

		pieChart.setImageResource(pieImageNumber);

		communityInfo = (TextView) findViewById(R.id.editText1);
		if (location.equals("alpine"))
			communityInfo.setText("In Alpine, 13.9% people die from cancer");
		else if (location.equals("central sd"))
			communityInfo.setText("In Central San Diego, 13.8% of people die from cancer");
		else if (location.equals("chula vista"))
			communityInfo.setText("In Chula Vista, 24.2% of people die from cancer");
		else if (location.equals("coronado"))
			communityInfo.setText("In Coronado, 16.2% of people die from cancer");
		else if (location.equals("del mar-mira mesa"))
			communityInfo.setText("In Del Mar-Mira Mesa, 9.5% of people die from cancer");
		else if (location.equals("la mesa"))
			communityInfo.setText("In La Mesa, 26.5% of people die from cancer");
		else if (location.equals("poway"))
			communityInfo.setText("In Poway, 11.7% of people die from cancer");
		else if (location.equals("santee"))
			communityInfo.setText("In Santee, 17.2% of people die from cancer");
		else if (location.equals("southeast sd"))
			communityInfo.setText("In Southeast San Diego, 15.1% of people die from cancer");
		else if (location.equals("university"))
			communityInfo.setText("In University, 10.3% of people die from cancer");

	}
}