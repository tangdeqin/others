package com.example.user.recyclerviewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by user on 19-3-20.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTR = new int[]{
            android.R.attr.listDivider
    };
    public static final int H = LinearLayoutManager.HORIZONTAL;
    public static final int V = LinearLayoutManager.VERTICAL;
    private Drawable mDivider;
    public int mOrientation;
    public DividerItemDecoration(Context context,int orientation){
        final TypedArray a = context.obtainStyledAttributes(ATTR);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);

    }

    public void setOrientation(int orientation){
        if(orientation!=H && orientation!=V){
            throw new IllegalArgumentException("");
        }
        mOrientation = orientation;
    }
    @Override
    public void getItemOffsets(Rect rect,int itemPosition,RecyclerView parent){
        if(mOrientation == V){
            rect.set(0,0,0,mDivider.getIntrinsicHeight());
        }
        else rect.set(0,0,mDivider.getIntrinsicWidth(),0);
    }
    @Override
    public void onDraw(Canvas c,RecyclerView parent){
        if(mOrientation ==V){
            drawV(c,parent);
        }
        else drawH(c,parent);
    }

    public void drawV(Canvas c,RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth()-parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for(int i = 0 ;i<childCount;i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
            final int top = child.getBottom()+params.bottomMargin;
            final int bottom = top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }
    public void drawH(Canvas c,RecyclerView parent){
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight()-parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for(int i = 0 ;i<childCount;i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
            final int left = child.getRight()+params.rightMargin;
            final int right = left+mDivider.getIntrinsicWidth();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

}
