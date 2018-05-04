@file:JvmName("Sdk15ServicesKt")
package org.jetbrains.anko


import android.content.Context
import android.view.accessibility.AccessibilityManager
import android.accounts.AccountManager
import android.app.ActivityManager
import android.app.AlarmManager
import android.media.AudioManager
import android.content.ClipboardManager
import android.net.ConnectivityManager
import android.app.admin.DevicePolicyManager
import android.app.DownloadManager
import android.view.inputmethod.InputMethodManager
import android.app.KeyguardManager
import android.location.LocationManager
import android.nfc.NfcManager
import android.app.NotificationManager
import android.os.PowerManager
import android.app.SearchManager
import android.hardware.SensorManager
import android.os.storage.StorageManager
import android.telephony.TelephonyManager
import android.app.UiModeManager
import android.hardware.usb.UsbManager
import android.app.WallpaperManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.view.WindowManager


/** Returns the AccessibilityManager instance. **/
val Context.accessibilityManager: AccessibilityManager
    get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager


/** Returns the AccountManager instance. **/
val Context.accountManager: AccountManager
    get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager


/** Returns the ActivityManager instance. **/
val Context.activityManager: ActivityManager
    get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager


/** Returns the AlarmManager instance. **/
val Context.alarmManager: AlarmManager
    get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager


/** Returns the AudioManager instance. **/
val Context.audioManager: AudioManager
    get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager


/** Returns the ClipboardManager instance. **/
val Context.clipboardManager: ClipboardManager
    get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager


/** Returns the ConnectivityManager instance. **/
val Context.connectivityManager: ConnectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


/** Returns the DevicePolicyManager instance. **/
val Context.devicePolicyManager: DevicePolicyManager
    get() = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager


/** Returns the DownloadManager instance. **/
val Context.downloadManager: DownloadManager
    get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager


/** Returns the InputMethodManager instance. **/
val Context.inputMethodManager: InputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


/** Returns the KeyguardManager instance. **/
val Context.keyguardManager: KeyguardManager
    get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager


/** Returns the LocationManager instance. **/
val Context.locationManager: LocationManager
    get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager


/** Returns the NfcManager instance. **/
val Context.nfcManager: NfcManager
    get() = getSystemService(Context.NFC_SERVICE) as NfcManager


/** Returns the NotificationManager instance. **/
val Context.notificationManager: NotificationManager
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


/** Returns the PowerManager instance. **/
val Context.powerManager: PowerManager
    get() = getSystemService(Context.POWER_SERVICE) as PowerManager


/** Returns the SearchManager instance. **/
val Context.searchManager: SearchManager
    get() = getSystemService(Context.SEARCH_SERVICE) as SearchManager


/** Returns the SensorManager instance. **/
val Context.sensorManager: SensorManager
    get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager


/** Returns the StorageManager instance. **/
val Context.storageManager: StorageManager
    get() = getSystemService(Context.STORAGE_SERVICE) as StorageManager


/** Returns the TelephonyManager instance. **/
val Context.telephonyManager: TelephonyManager
    get() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager


/** Returns the UiModeManager instance. **/
val Context.uiModeManager: UiModeManager
    get() = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager


/** Returns the UsbManager instance. **/
val Context.usbManager: UsbManager
    get() = getSystemService(Context.USB_SERVICE) as UsbManager


/** Returns the WallpaperManager instance. **/
val Context.wallpaperManager: WallpaperManager
    get() = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager


/** Returns the WifiManager instance. **/
val Context.wifiManager: WifiManager
    get() = getSystemService(Context.WIFI_SERVICE) as WifiManager


/** Returns the WifiP2pManager instance. **/
val Context.wifiP2pManager: WifiP2pManager
    get() = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager


/** Returns the WindowManager instance. **/
val Context.windowManager: WindowManager
    get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager

