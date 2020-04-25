package app.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PhoneActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone);
	}

	public void leftClick(View view) {
		PlayerActivity.URL = R.string.mp4_video3;
		startActivity(new Intent(this, PlayerActivity.class));
	}

	public void rightClick(View view) {
		PlayerActivity.URL = R.string.mp4_video4;
		startActivity(new Intent(this, PlayerActivity.class));
	}
}
