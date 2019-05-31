package com.example.tdq.as.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;


public class MyButton extends android.support.v7.widget.AppCompatButton {
    private String textValue = "";
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyButtonProperties);
        String textValue = typedArray.getString(R.styleable.MyButtonProperties_tag);
        if(textValue.isEmpty()){
            this.textValue = "";
        }else {
            this.textValue = textValue;
        }
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setText(textValue);
    }
}
