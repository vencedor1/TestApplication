package app.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PhoneSchedulerActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_scheduler);
	}

	public void helpClick(View view) {
		//Toast.makeText(this, R.string.help, Toast.LENGTH_LONG).show();
		PlayerActivity.URL = R.string.mp4_video7;
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
								Common.showHelp = true;
								startActivity(new Intent(context, SocialNetActivity.class));
							}
						}
				).start();
	}

	public void buttonPClick(View view) {
		Toast.makeText(this, "P", Toast.LENGTH_SHORT).show();
	}

	public void buttonLClick(View view) {
		Toast.makeText(this, "L", Toast.LENGTH_SHORT).show();
		//startActivity(new Intent(this, SocialNetActivity.class));
		String geoUriString = "geo:46.460323,30.749954?z=16";
		//String geoUriString = "geo:0,0?q=ONPU";
		//geo:0,0?q=address
		//String geoUriString = "google.streetview:cbll=46.460323,30.749954&cbp=1,99.56,,1,2.0&mz=19";
		Uri geoUri = Uri.parse(geoUriString);
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
		if (mapIntent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(mapIntent, 1);
		}
	}

	public void buttonEClick(View view) {
		Toast.makeText(this, "E", Toast.LENGTH_SHORT).show();
	}

	public void buttonKClick(View view) {
		Toast.makeText(this, "K", Toast.LENGTH_SHORT).show();
	}
}
