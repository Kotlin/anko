/*
 * Copyright 2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.android.robowrapper;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Config(manifest= Config.NONE, emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class BaseViewResolverTest {

    @Test
    public void testActivity() throws Exception {
        execTests(MyActivity.class);
    }

    @Test
    public void testFragment() throws Exception {
        execTests(MyFragment.class);
    }

    @Test
    public void testSupportFragment() throws Exception {
        execTests(MySupportFragment.class);
    }

    @Test
    public void testInvalidClass() throws Exception {
        boolean thr = false;
        try {
            execTests(Object.class);
        } catch (UnsupportedClassException e) {
            thr = true;
        }
        assertTrue(thr);
    }

    public void execTests(Class clazz) throws Exception {
        View v = new BaseViewResolver().getBaseView(clazz);

        assertTrue(v instanceof LinearLayout);
        LinearLayout linearLayout = (LinearLayout)v;
        assertEquals(2, linearLayout.getChildCount());
        assertTrue(linearLayout.getChildAt(0) instanceof TextView);
    }

    private static View genSimpleHierarchy(Context context) {
        LinearLayout layout = new LinearLayout(context);
        TextView view = new TextView(context);
        Button button = new Button(context);
        layout.addView(view);
        layout.addView(button);
        return layout;
    }

    public static class MyActivity extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(genSimpleHierarchy(this));
        }
    }

    public static class MyFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return genSimpleHierarchy(getActivity());
        }
    }

    public static class MySupportFragment extends android.support.v4.app.Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return genSimpleHierarchy(getActivity());
        }
    }

}
