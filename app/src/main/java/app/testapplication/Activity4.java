package app.testapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class Activity4 extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_4);
		ListView listView = findViewById(R.id.listView);

		String[] items = getResources().getStringArray(R.array.stringList);
		// создаем адаптер
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

		// присваиваем адаптер списку
		listView.setAdapter(adapter);
	}

	public void button1Click(View view) {
		finish();
	}

	public void helpClick(View view) {
		Toast.makeText(this, R.string.help , Toast.LENGTH_SHORT).show();
		startActivity(new Intent(this, HelpActivity.class));
	}

	public void searchClick(View view) {
		Toast.makeText(this, R.string.search , Toast.LENGTH_SHORT).show();
	}

	public void contactsClick(View view) {
		Toast.makeText(this, R.string.contacts , Toast.LENGTH_SHORT).show();
	}

	public void watchTV(View view) {
		PlayerActivity.URL = R.string.mp4_video1;
		startActivity(new Intent(this, PlayerActivity.class));
	}

	public void comeAndWatchTV(View view) {
		PlayerActivity.URL = R.string.mp4_video2;
		startActivity(new Intent(this, PlayerActivity.class));
	}
}
