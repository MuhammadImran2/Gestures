package com.example.gestures;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView ;
import android.view.MotionEvent ;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat ;

public class MainActivity extends AppCompatActivity  implements  GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{


    private TextView text_view;
    private GestureDetectorCompat gestureDetector ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        text_view = (TextView)findViewById(R.id.text_view);
        this.gestureDetector = new GestureDetectorCompat(this , this);
        gestureDetector.setOnDoubleTapListener(this);

    }


    /////////////////////Gesture Start /////////////////////////////////////////////

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        text_view.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        text_view.setText("onDoubleTap");
        return true ;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        text_view.setText("onDoubleTapEvent");
        return true ;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        text_view.setText("onDown");
        return true ;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        text_view.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        text_view.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        text_view.setText("onScroll");
        return  true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        text_view.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        text_view.setText("onFling");
        return true;
    }

    ///////////////// Gesture END ////////////////////////////////////


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
