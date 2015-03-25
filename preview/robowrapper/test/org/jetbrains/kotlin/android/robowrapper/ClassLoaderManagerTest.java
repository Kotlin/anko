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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@Config(manifest= Config.NONE, emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class ClassLoaderManagerTest {

    @Test
    public void testClassLoaderManager() throws Exception {
        Activity a = Robolectric.setupActivity(Activity.class);
        assertNotNull(a);

        ClassLoaderManager manager = new ClassLoaderManager();
        String className = "org.jetbrains.kotlin.android.robowrapper.test.SomeClass";

        ClassLoader cl1 = getContextClassLoader();
        Object o1 = cl1.loadClass(className);

        manager.replaceClassLoader("org.jetbrains.kotlin.android.robowrapper.test.");

        ClassLoader cl2 = getContextClassLoader();
        Object o2 = cl2.loadClass(className);

        manager.replaceClassLoader("org.jetbrains.kotlin.android.robowrapper.test.somethingNotExist");
        ClassLoader cl3 = getContextClassLoader();
        Object o3 = cl3.loadClass(className);

        assertNotEquals(o1, o2);
        assertEquals(o2, o3);
    }

    private ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

}
