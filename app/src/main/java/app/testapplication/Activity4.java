package app.testapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_4);

		ListView listView = findViewById(R.id.listView1);
		String[] items = getResources().getStringArray(R.array.stringList);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		listView.setAdapter(adapter);
	}

	public void button1Click(View view) {
		finish();
	}

	public void helpClick(View view) {
		Toast.makeText(this, R.string.help, Toast.LENGTH_SHORT).show();
		startActivity(new Intent(this, HelpActivity.class));

	}

	public void searchClick(View view) {
		Toast.makeText(this, R.string.search, Toast.LENGTH_SHORT).show();
	}

	public void contactsClick(View view) {
		Toast.makeText(this, R.string.contacts, Toast.LENGTH_SHORT).show();
	}

	public void watchTV(View view) {
		PlayerActivity.URL = R.string.mp4_video1;
		startActivity(new Intent(this, PlayerActivity.class));
	}

	public void comeAndWatchTV(View view) {
		PlayerActivity.URL = R.string.mp4_video2;
		startActivity(new Intent(this, PlayerActivity.class));
		Common.isWaiting = true;
		Context context = this;
		new Thread
				(
						new Runnable()
						{
							@Override
							public void run() {
								do {
								} while (Common.isWaiting);
								startActivity(new Intent(context, PhoneActivity.class));
							}
						}
				).start();
	}
}
