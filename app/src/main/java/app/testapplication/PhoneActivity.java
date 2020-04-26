package app.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.google.android.exoplayer2.Player;

public class PhoneActivity extends AppCompatActivity
{
	ListView listView;
	public static int position = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone);

		listView = findViewById(R.id.listView1);
		String[] items = getResources().getStringArray(R.array.phoneBook);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		listView.setAdapter(adapter);
		listView.setFocusable(true);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.d("ListClick", "itemClick: position = " + (PhoneActivity.position = position) + ", id = " + id);
			}
		});
	}

	public void callClick(View view) {
		Common.isWaiting = true;
		Context context = this;

		if (PhoneActivity.position == 5) {
			PlayerActivity.URL = R.string.mp4_video4;
			listView.setVisibility(View.INVISIBLE);
			findViewById(R.id.phonePerson).setVisibility(View.VISIBLE);
			((ImageButton)findViewById(R.id.imageButtonLeft)).setImageResource(R.drawable.call2);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			startActivity(new Intent(this, PlayerActivity.class));

			new Thread
					(
							new Runnable()
							{
								@Override
								public void run() {
									do {
									} while (Common.isWaiting);
									startActivity(new Intent(context, AgreementActivity.class));								}
							}
					).start();
		} else {
			PlayerActivity.URL = R.string.mp4_video6;
			//Toast.makeText(this, R.string.callItem, Toast.LENGTH_LONG).show();
			startActivity(new Intent(this, PlayerActivity.class));
			new Thread
					(
							new Runnable()
							{
								@Override
								public void run() {
									do {
									} while (Common.isWaiting);
									//Toast.makeText(context, R.string.callItem, Toast.LENGTH_LONG).show();
									//finish();
								}
							}
					).start();
//			finish();
		}
	}
}