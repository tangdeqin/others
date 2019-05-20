package com.example.user.preferenceactivitytest;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class PreferenceActivityTest extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}
