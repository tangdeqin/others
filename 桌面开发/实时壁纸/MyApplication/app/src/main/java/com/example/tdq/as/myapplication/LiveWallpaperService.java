package com.example.tdq.as.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

public class LiveWallpaperService extends WallpaperService {
    @Override
    public Engine onCreateEngine() {
        return new MyEngine();
    }
    public class  MyEngine extends Engine{
        private Boolean mVisible;
        private float cx = 15;
        private float cy = 20;
        private Paint paint = new Paint();
        Handler handler = new Handler();
        private final Runnable drawTarget = new Runnable() {
            @Override
            public void run() {
                drawFrame();
            }
        };
        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            paint.setColor(0xffffffff);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(2);
            paint.setStyle(Paint.Style.STROKE);
            setTouchEventsEnabled(true);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            super.onVisibilityChanged(visible);
            mVisible = visible;
            if(visible){
                drawFrame();
            }else {
                handler.removeCallbacks(drawTarget);
            }
        }

        @Override
        public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
            super.onOffsetsChanged(xOffset, yOffset, xOffsetStep, yOffsetStep, xPixelOffset, yPixelOffset);
            drawFrame();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            handler.removeCallbacks(drawTarget);
        }

        private  void drawFrame(){
            final SurfaceHolder holder = getSurfaceHolder();
            Canvas c = null;
            try{
                c = holder.lockCanvas();
                if(c!=null){
                    c.save();
                    c.drawColor(0xff000000);
                    c.drawCircle(cx,cy,80,paint);
                    c.restore();
                }
            }finally {
                if(c!=null){
                    holder.unlockCanvasAndPost(c);
                }
            }
            handler.removeCallbacks(drawTarget);
            if(mVisible){
                cx+=15;
                cy+=20;
                if (cx>500) cx = 15;
                if(cy > 1000) cy = 20;
                handler.postDelayed(drawTarget,100);
            }
        }
    }
}
