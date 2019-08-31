/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.applications.specialaccess.vrlistener;

import android.app.ActivityManager;
import android.content.Context;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class EnabledVrListenersController extends BasePreferenceController {

    private final ActivityManager mActivityManager;

    public EnabledVrListenersController(Context context, String key) {
        super(context, key);
        mActivityManager = mContext.getSystemService(ActivityManager.class);
    }

    @AvailabilityStatus
    public int getAvailabilityStatus() {
        return mContext.getResources().getBoolean(R.bool.config_show_enabled_vr_listeners)
                && !mActivityManager.isLowRamDevice()
                ? AVAILABLE_UNSEARCHABLE
                : UNSUPPORTED_ON_DEVICE;
    }
}