public val Context.accessibilityManager: android.view.accessibility.AccessibilityManager
  get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as android.view.accessibility.AccessibilityManager
public val Context.accountManager: android.accounts.AccountManager
  get() = getSystemService(Context.ACCOUNT_SERVICE) as android.accounts.AccountManager
public val Context.activityManager: android.app.ActivityManager
  get() = getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
public val Context.alarmManager: android.app.AlarmManager
  get() = getSystemService(Context.ALARM_SERVICE) as android.app.AlarmManager
public val Context.audioManager: android.media.AudioManager
  get() = getSystemService(Context.AUDIO_SERVICE) as android.media.AudioManager
public val Context.clipboardManager: android.text.ClipboardManager
  get() = getSystemService(Context.CLIPBOARD_SERVICE) as android.text.ClipboardManager
public val Context.connectivityManager: android.net.ConnectivityManager
  get() = getSystemService(Context.CONNECTIVITY_SERVICE) as android.net.ConnectivityManager
public val Context.devicePolicyManager: android.app.admin.DevicePolicyManager
  get() = getSystemService(Context.DEVICE_POLICY_SERVICE) as android.app.admin.DevicePolicyManager
public val Context.downloadManager: android.app.DownloadManager
  get() = getSystemService(Context.DOWNLOAD_SERVICE) as android.app.DownloadManager
public val Context.inputMethodManager: android.view.inputmethod.InputMethodManager
  get() = getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
public val Context.keyguardManager: android.app.KeyguardManager
  get() = getSystemService(Context.KEYGUARD_SERVICE) as android.app.KeyguardManager
public val Context.locationManager: android.location.LocationManager
  get() = getSystemService(Context.LOCATION_SERVICE) as android.location.LocationManager
public val Context.nfcManager: android.nfc.NfcManager
  get() = getSystemService(Context.NFC_SERVICE) as android.nfc.NfcManager
public val Context.notificationManager: android.app.NotificationManager
  get() = getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
public val Context.powerManager: android.os.PowerManager
  get() = getSystemService(Context.POWER_SERVICE) as android.os.PowerManager
public val Context.searchManager: android.app.SearchManager
  get() = getSystemService(Context.SEARCH_SERVICE) as android.app.SearchManager
public val Context.sensorManager: android.hardware.SensorManager
  get() = getSystemService(Context.SENSOR_SERVICE) as android.hardware.SensorManager
public val Context.storageManager: android.os.storage.StorageManager
  get() = getSystemService(Context.STORAGE_SERVICE) as android.os.storage.StorageManager
public val Context.telephonyManager: android.telephony.TelephonyManager
  get() = getSystemService(Context.TELEPHONY_SERVICE) as android.telephony.TelephonyManager
public val Context.uiModeManager: android.app.UiModeManager
  get() = getSystemService(Context.UI_MODE_SERVICE) as android.app.UiModeManager
public val Context.usbManager: android.hardware.usb.UsbManager
  get() = getSystemService(Context.USB_SERVICE) as android.hardware.usb.UsbManager
public val Context.wallpaperManager: android.app.WallpaperManager
  get() = getSystemService(Context.WALLPAPER_SERVICE) as android.app.WallpaperManager
public val Context.wifiP2pManager: android.net.wifi.p2p.WifiP2pManager
  get() = getSystemService(Context.WIFI_P2P_SERVICE) as android.net.wifi.p2p.WifiP2pManager
public val Context.wifiManager: android.net.wifi.WifiManager
  get() = getSystemService(Context.WIFI_SERVICE) as android.net.wifi.WifiManager
public val Context.windowManager: android.view.WindowManager
  get() = getSystemService(Context.WINDOW_SERVICE) as android.view.WindowManager
