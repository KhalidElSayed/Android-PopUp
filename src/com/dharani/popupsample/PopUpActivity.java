package com.dharani.popupsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


public class PopUpActivity extends Activity {

	private Animation animShow,animHide;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup);
		init_pop();
	}
	
	private void init_pop(){
		final TransparentPanel popup=(TransparentPanel) findViewById(R.id.pop_window);
		
		popup.setVisibility(View.GONE);
		
		animShow = AnimationUtils.loadAnimation(this, R.anim.popup_show);
		animHide = AnimationUtils.loadAnimation(this, R.anim.popup_hide);
		
		final Button showButton = (Button) findViewById(R.id.show_pop_up);
		final Button hideButton =(Button) findViewById(R.id.hide_popup_button);
		
		showButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popup.setVisibility(View.VISIBLE);
				popup.startAnimation(animShow);
				showButton.setEnabled(false);
				hideButton.setEnabled(true);
			}
		});
		
		hideButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popup.startAnimation(animHide);
				showButton.setEnabled(true);
				hideButton.setEnabled(false);
				popup.setVisibility(View.GONE);
			}
		});
		
		final TextView locationName = (TextView) findViewById(R.id.location_name);
        final TextView locationDescription = (TextView) findViewById(R.id.location_description);
         
        locationName.setText("Animated Popup");
        locationDescription.setText("In this example Animated popup is created to explaing custom popupwindow example."
                                    + " Transparent layout and animation is also used to customized the window"
                                    + "All the best....Have a good learning.");
	}
	

}
