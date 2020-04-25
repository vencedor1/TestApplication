package app.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
	public static final String URL = "Test MESSAGE";
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = findViewById(R.id.textView);
	}

	public void click(View view) {
		//Toast.makeText(this, "Opened", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, Main2Activity.class);
		String message = textView.getText().toString();
		intent.putExtra(URL, message);
		Bundle bundle = getIntent().getExtras();
		startActivityForResult(intent, 1, bundle);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (data == null) {
			return;
		}
		String value = data.getStringExtra("value");

		textView.setText("Received: " + value);
	}
}
