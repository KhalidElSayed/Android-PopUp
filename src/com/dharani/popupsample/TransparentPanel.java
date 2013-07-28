package com.dharani.popupsample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class TransparentPanel extends LinearLayout {

	private Paint innerPaint,borderPaint;
	public TransparentPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}
	
	public TransparentPanel(Context context) {
        super(context);
        init();
    }
	
	private void init(){
		innerPaint =new Paint();
		innerPaint.setARGB(255, 0, 0, 0);
		innerPaint.setAntiAlias(true);  //smooth out the edges
		
		borderPaint=new Paint();
		borderPaint.setARGB(255, 0, 0, 0);
		borderPaint.setAntiAlias(true);
		borderPaint.setStyle(Style.STROKE);
		borderPaint.setStrokeWidth(2);
	}
	
	public void setInnerPaint(Paint innerPaint){
		this.innerPaint=innerPaint;
	}
	
	public void setBorderPaint(Paint borderPaint){
		this.borderPaint=borderPaint;
	}
	
	
	protected void dispatchDraw(Canvas canvas){
		
		RectF drawRect=new RectF();
		drawRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
		
		canvas.drawRoundRect(drawRect, 5, 5, innerPaint);
		canvas.drawRoundRect(drawRect, 5, 5, borderPaint);
		
		super.dispatchDraw(canvas);
	}

}
