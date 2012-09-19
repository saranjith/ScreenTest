package com.example.screentest;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.Toast;

public class SwipeGesture extends Activity {
	WebView wv;
	int pos=0;
	String[] urls={"http://www.google.com","http://www.facebook.com","http://www.twiter.com"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_gesture);
        final GestureDetector gestureDetector = new GestureDetector(new DetectGesture());
//        TextView swipeText = (TextView)findViewById(R.id.swipeText);
//        swipeText.setOnTouchListener(new OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View arg0, MotionEvent event) {
//				gestureDetector.onTouchEvent(event);
//	            return true;
//			}
//		});
        
        wv = (WebView)findViewById(R.id.webView1);
        wv.loadUrl(urls[pos]);
        System.out.println("page 0 loaded  "+ urls[pos]);
        //pos++;
        wv.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				gestureDetector.onTouchEvent(event);
	            return true;
			}
		});
    }

    

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private class DetectGesture extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            	if(pos>=0){
            		if(pos<urls.length-1)
            		{
            			pos++;
            			System.out.println("page "+pos+" loaded "+urls[pos]);
            			
            		}else{
            			Toast.makeText(getApplicationContext(), "no more pages", Toast.LENGTH_SHORT).show();
            			System.out.println("no more pages");
            			pos=urls.length;
            			pos--;
            		}
            		//wv.loadUrl(urls[pos]);	
            	}
            	System.out.println("Right to left");
                return true; 
            }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            			
	            	if(pos>0){
	            		pos--;
	            		System.out.println("page "+pos+" loaded "+urls[pos]);
	            	}else{
	        			Toast.makeText(getApplicationContext(), "no more pages", Toast.LENGTH_SHORT).show();
	        			System.out.println("no more pages");
	        			pos=0;
	        			
	            	}
            	System.out.println("left to right");
                return true; 
            }
            if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            	System.out.println("Bottom to top");
                return true; 
            }  else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            	System.out.println("Top to bottom");
                return true; 
            }
            return false;
        }
    }
  
}
