val Context.accessibilityManager: android.view.accessibility.AccessibilityManager
    get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as android.view.accessibility.AccessibilityManager

val Context.accountManager: android.accounts.AccountManager
    get() = getSystemService(Context.ACCOUNT_SERVICE) as android.accounts.AccountManager

val Context.activityManager: android.app.ActivityManager
    get() = getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager

val Context.alarmManager: android.app.AlarmManager
    get() = getSystemService(Context.ALARM_SERVICE) as android.app.AlarmManager

val Context.audioManager: android.media.AudioManager
    get() = getSystemService(Context.AUDIO_SERVICE) as android.media.AudioManager

val Context.clipboardManager: android.text.ClipboardManager
    get() = getSystemService(Context.CLIPBOARD_SERVICE) as android.text.ClipboardManager

val Context.connectivityManager: android.net.ConnectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as android.net.ConnectivityManager

val Context.devicePolicyManager: android.app.admin.DevicePolicyManager
    get() = getSystemService(Context.DEVICE_POLICY_SERVICE) as android.app.admin.DevicePolicyManager

val Context.downloadManager: android.app.DownloadManager
    get() = getSystemService(Context.DOWNLOAD_SERVICE) as android.app.DownloadManager

val Context.inputMethodManager: android.view.inputmethod.InputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager

val Context.keyguardManager: android.app.KeyguardManager
    get() = getSystemService(Context.KEYGUARD_SERVICE) as android.app.KeyguardManager

val Context.locationManager: android.location.LocationManager
    get() = getSystemService(Context.LOCATION_SERVICE) as android.location.LocationManager

val Context.nfcManager: android.nfc.NfcManager
    get() = getSystemService(Context.NFC_SERVICE) as android.nfc.NfcManager

val Context.notificationManager: android.app.NotificationManager
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager

val Context.powerManager: android.os.PowerManager
    get() = getSystemService(Context.POWER_SERVICE) as android.os.PowerManager

val Context.searchManager: android.app.SearchManager
    get() = getSystemService(Context.SEARCH_SERVICE) as android.app.SearchManager

val Context.sensorManager: android.hardware.SensorManager
    get() = getSystemService(Context.SENSOR_SERVICE) as android.hardware.SensorManager

val Context.storageManager: android.os.storage.StorageManager
    get() = getSystemService(Context.STORAGE_SERVICE) as android.os.storage.StorageManager

val Context.telephonyManager: android.telephony.TelephonyManager
    get() = getSystemService(Context.TELEPHONY_SERVICE) as android.telephony.TelephonyManager

val Context.uiModeManager: android.app.UiModeManager
    get() = getSystemService(Context.UI_MODE_SERVICE) as android.app.UiModeManager

val Context.usbManager: android.hardware.usb.UsbManager
    get() = getSystemService(Context.USB_SERVICE) as android.hardware.usb.UsbManager

val Context.wallpaperManager: android.app.WallpaperManager
    get() = getSystemService(Context.WALLPAPER_SERVICE) as android.app.WallpaperManager

val Context.wifiP2pManager: android.net.wifi.p2p.WifiP2pManager
    get() = getSystemService(Context.WIFI_P2P_SERVICE) as android.net.wifi.p2p.WifiP2pManager

val Context.wifiManager: android.net.wifi.WifiManager
    get() = getSystemService(Context.WIFI_SERVICE) as android.net.wifi.WifiManager

val Context.windowManager: android.view.WindowManager
    get() = getSystemService(Context.WINDOW_SERVICE) as android.view.WindowManager