/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.android.settings.core.lifecycle;


import android.annotation.CallSuper;
import android.content.Context;
import android.os.Bundle;
import android.support.v14.preference.PreferenceFragment;

/**
 * {@link PreferenceFragment} that has hooks to observe fragment lifecycle events.
 */
public abstract class ObservablePreferenceFragment extends PreferenceFragment {

    private final Lifecycle mLifecycle = new Lifecycle();

    protected Lifecycle getLifecycle() {
        return mLifecycle;
    }

    @CallSuper
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mLifecycle.onAttach(context);
    }

    @CallSuper
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLifecycle.onCreate(savedInstanceState);
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mLifecycle.onSaveInstanceState(outState);
    }

    @CallSuper
    @Override
    public void onStart() {
        mLifecycle.onStart();
        super.onStart();
    }

    @CallSuper
    @Override
    public void onResume() {
        mLifecycle.onResume();
        super.onResume();
    }

    @CallSuper
    @Override
    public void onPause() {
        mLifecycle.onPause();
        super.onPause();
    }

}