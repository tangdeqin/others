package com.example.tdq.as.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by TDQ on 2019/6/15.
 */

public class MyView extends View {
    public MyView(Context context,AttributeSet attributeSet) {
        super(context,attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        //圆
        canvas.drawCircle(40,40,30,paint);
        //矩形
        RectF rectF = new RectF(10,70,70,120);
        canvas.drawRect(rectF,paint);

        canvas.drawRect(10,130,70,160,paint);

        //圆角矩形
        RectF rectF1 = new RectF(10,170,70,200);
        canvas.drawRoundRect(rectF1,15,5,paint);

        //椭圆
        RectF rectF2 = new RectF(10,210,70,250);
        canvas.drawOval(rectF2,paint);

        //多边形
        Path path = new Path();
        path.moveTo(10,260);
        path.lineTo(10,300);
        path.lineTo(70,300);
        path.close();
        canvas.drawPath(path,paint);

        //直线
        canvas.drawLine(10,310,70,310,paint);

        //弧线
        RectF rectF3 = new RectF(10,320,200,500);
        canvas.drawArc(rectF3,0,100,false,paint);

        RectF rectF4 = new RectF(10,600,200,800);
        canvas.drawArc(rectF4,0,100,true,paint);

        //文字
        paint.setTextSize(24);
        paint.setTextAlign(Paint.Align.CENTER);//居中对齐
        canvas.drawText("我爱中华人民共和国",300,900,paint);

        paint.setTextAlign(Paint.Align.LEFT);//居左对齐
        canvas.drawText("我爱中华人民共和国",300,1000,paint);

        paint.setTextAlign(Paint.Align.RIGHT);//居右对齐
        canvas.drawText("我爱中华人民共和国",300,1100,paint);
    }
}
