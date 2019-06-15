package com.example.tdq.as.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by TDQ on 2019/6/15.
 */

public class MyView extends View {
    Paint paint;
    PathEffect[] pathEffect = new PathEffect[7];
    Path path;
    float phase;

    public MyView(Context context,AttributeSet attributeSet) {
        super(context,attributeSet);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);

        path = new Path();
        path.moveTo(0,0);
        for(int i=0;i<=15;i++){
            path.lineTo(i*20,(float)Math.random()*60);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        canvas.translate(60,60);
        pathEffect[0] = null;
        paint.setPathEffect(pathEffect[0]);
        canvas.drawPath(path,paint);

        canvas.translate(0,60);
        pathEffect[1] = new CornerPathEffect(10);
        paint.setPathEffect(pathEffect[1]);
        canvas.drawPath(path,paint);

        canvas.translate(0,60);
        pathEffect[2] = new DiscretePathEffect(10.0f,10.0f);
        paint.setPathEffect(pathEffect[2]);
        canvas.drawPath(path,paint);

        canvas.translate(0,60);
        pathEffect[3] = new DashPathEffect(new float[]{20,10},phase);
        paint.setPathEffect(pathEffect[3]);
        canvas.drawPath(path,paint);

        canvas.translate(0,60);
        pathEffect[4] = new ComposePathEffect(pathEffect[1],pathEffect[2]);
        paint.setPathEffect(pathEffect[4]);
        canvas.drawPath(path,paint);

        canvas.translate(0,60);
        pathEffect[5] = new SumPathEffect(pathEffect[1],pathEffect[2]);
        paint.setPathEffect(pathEffect[5]);
        canvas.drawPath(path,paint);

        phase++;
        invalidate();

    }
}
