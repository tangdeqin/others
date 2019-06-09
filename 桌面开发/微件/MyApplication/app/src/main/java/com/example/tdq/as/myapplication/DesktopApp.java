package com.example.tdq.as.myapplication;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

/**
 * Created by TDQ on 2019/6/9.
 */

public class DesktopApp extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.wigit);
        remoteViews.setImageViewResource(R.id.icon,R.drawable.ic_launcher_foreground);
        ComponentName componentName = new ComponentName(context,DesktopApp.class);
        appWidgetManager.updateAppWidget(componentName,remoteViews);
    }
}
