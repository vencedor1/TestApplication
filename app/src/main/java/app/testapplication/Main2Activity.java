package app.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity
{
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		intent = getIntent();
		String message = intent.getStringExtra(MainActivity.URL);
	}


	public void click(View view) {
/*		intent.putExtra("value", textView.getText().toString());
		setResult(RESULT_OK, intent);
		finish();
		*/
	}

	public void choose(View view) {
		Toast.makeText(this, R.string.choose, Toast.LENGTH_SHORT).show();
	}

	public void left(View view) {
		Toast.makeText(this, R.string.left , Toast.LENGTH_SHORT).show();
	}

	public void right(View view) {
		Toast.makeText(this, R.string.right , Toast.LENGTH_SHORT).show();
	}

	public void up(View view) {
		Toast.makeText(this, R.string.up , Toast.LENGTH_SHORT).show();
	}

	public void down(View view) {
		Toast.makeText(this, R.string.down , Toast.LENGTH_SHORT).show();
		Intent intent1 = new Intent(this, Activity4.class);
		intent1.putExtra("", R.string.actor);
		Bundle bundle = getIntent().getExtras();
		startActivityForResult(intent1, 1, bundle);
	}

	public void button1Click(View view) {
		finish();
	}

	public void helpClick(View view) {
		Toast.makeText(this, R.string.help , Toast.LENGTH_SHORT).show();
		Intent intent1 = new Intent(this, HelpActivity.class);
		startActivity(intent1);
	}

	public void searchClick(View view) {
		Toast.makeText(this, R.string.search , Toast.LENGTH_SHORT).show();
	}

	public void contactsClick(View view) {
		Toast.makeText(this, R.string.contacts , Toast.LENGTH_SHORT).show();
	}
}
