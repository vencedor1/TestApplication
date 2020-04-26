package app.testapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgreementActivity extends AppCompatActivity
{
	MultiAutoCompleteTextView multiAutoCompleteTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agreement);

		multiAutoCompleteTextView = findViewById(R.id.TextViewAgreement);
		multiAutoCompleteTextView.clearComposingText();
		String[] items = getResources().getStringArray(R.array.agreement);
		String lines = "";
		for (String line : items) {
			lines += "\n" + line;
		}
		multiAutoCompleteTextView.setText(lines);
	}

	public void takeButton(View view) {
		Toast.makeText(this, R.string.agreementTaken, Toast.LENGTH_LONG).show();
		PlayerActivity.URL = R.string.mp4_video5;
		startActivity(new Intent(this, PlayerActivity.class));
		Context context = this;
		Common.isWaiting = true;
		new Thread
				(
						new Runnable()
						{
							@Override
							public void run() {
								do {
								} while (Common.isWaiting);
								startActivity(new Intent(context, PhoneActivity.class));
/*								MapsActivity map = new MapsActivity();
								setContentView(R.layout.activity_maps);*/
							}
						}
				).start();
	}
}
