package com.example.ratingbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class MainActivity extends Activity implements OnRatingBarChangeListener {
    private ImageView imageview;
    private RatingBar ratingbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Uiinit();
	}
	public void Uiinit(){
		imageview = (ImageView)findViewById(R.id.imageView1);
		ratingbar = (RatingBar)findViewById(R.id.ratingBar1);
		ratingbar.setOnRatingBarChangeListener(this);
	}
	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
		imageview.setAlpha((int)(rating*255/5));
	}
}
