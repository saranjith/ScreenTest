package com.example.screentest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Screen1 extends Activity {

	/** Called when the activity is first created. */
	ImageView img ;
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_screen1);
	    
	    TextView tv = (TextView)findViewById(R.id.textView1);
	    String text = tv.getText().toString();
	    EllipsizingTextView etv = (EllipsizingTextView)findViewById(R.id.ellipsizingTextView1);
	    etv.setMaxLines(1);
	}

}