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

package org.jetbrains.kotlin.android.robowrapper

import android.os.Build
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.manifest.AndroidManifest
import org.robolectric.res.Fs

public class CustomRobolectricTestRunner(clazz: Class<*>) : RobolectricTestRunner(clazz) {

    override fun getAppManifest(config: Config?): AndroidManifest? {
        val manifest = super.getAppManifest(config) ?: return null

        return if (manifest.getTargetSdkVersion() < 10) {
            object : AndroidManifest(manifest.getAndroidManifestFile(), manifest.getResDirectory(), manifest.getAssetsDirectory()) {
                override fun getTargetSdkVersion(): Int {
                    return Build.VERSION_CODES.LOLLIPOP
                }
            }
        } else manifest
    }


}