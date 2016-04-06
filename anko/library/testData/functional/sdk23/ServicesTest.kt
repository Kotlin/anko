val Context.accessibilityManager: android.view.accessibility.AccessibilityManager
    get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as android.view.accessibility.AccessibilityManager

val Context.accountManager: android.accounts.AccountManager
    get() = getSystemService(Context.ACCOUNT_SERVICE) as android.accounts.AccountManager

val Context.activityManager: android.app.ActivityManager
    get() = getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager

val Context.alarmManager: android.app.AlarmManager
    get() = getSystemService(Context.ALARM_SERVICE) as android.app.AlarmManager

val Context.appOpsManager: android.app.AppOpsManager
    get() = getSystemService(Context.APP_OPS_SERVICE) as android.app.AppOpsManager

val Context.audioManager: android.media.AudioManager
    get() = getSystemService(Context.AUDIO_SERVICE) as android.media.AudioManager

val Context.batteryManager: android.os.BatteryManager
    get() = getSystemService(Context.BATTERY_SERVICE) as android.os.BatteryManager

val Context.bluetoothManager: android.bluetooth.BluetoothManager
    get() = getSystemService(Context.BLUETOOTH_SERVICE) as android.bluetooth.BluetoothManager

val Context.cameraManager: android.hardware.camera2.CameraManager
    get() = getSystemService(Context.CAMERA_SERVICE) as android.hardware.camera2.CameraManager

val Context.captioningManager: android.view.accessibility.CaptioningManager
    get() = getSystemService(Context.CAPTIONING_SERVICE) as android.view.accessibility.CaptioningManager

val Context.carrierConfigManager: android.telephony.CarrierConfigManager
    get() = getSystemService(Context.CARRIER_CONFIG_SERVICE) as android.telephony.CarrierConfigManager

val Context.clipboardManager: android.text.ClipboardManager
    get() = getSystemService(Context.CLIPBOARD_SERVICE) as android.text.ClipboardManager

val Context.connectivityManager: android.net.ConnectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as android.net.ConnectivityManager

val Context.consumerIrManager: android.hardware.ConsumerIrManager
    get() = getSystemService(Context.CONSUMER_IR_SERVICE) as android.hardware.ConsumerIrManager

val Context.devicePolicyManager: android.app.admin.DevicePolicyManager
    get() = getSystemService(Context.DEVICE_POLICY_SERVICE) as android.app.admin.DevicePolicyManager

val Context.displayManager: android.hardware.display.DisplayManager
    get() = getSystemService(Context.DISPLAY_SERVICE) as android.hardware.display.DisplayManager

val Context.downloadManager: android.app.DownloadManager
    get() = getSystemService(Context.DOWNLOAD_SERVICE) as android.app.DownloadManager

val Context.fingerprintManager: android.hardware.fingerprint.FingerprintManager
    get() = getSystemService(Context.FINGERPRINT_SERVICE) as android.hardware.fingerprint.FingerprintManager

val Context.inputMethodManager: android.view.inputmethod.InputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager

val Context.inputManager: android.hardware.input.InputManager
    get() = getSystemService(Context.INPUT_SERVICE) as android.hardware.input.InputManager

val Context.keyguardManager: android.app.KeyguardManager
    get() = getSystemService(Context.KEYGUARD_SERVICE) as android.app.KeyguardManager

val Context.locationManager: android.location.LocationManager
    get() = getSystemService(Context.LOCATION_SERVICE) as android.location.LocationManager

val Context.mediaProjectionManager: android.media.projection.MediaProjectionManager
    get() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as android.media.projection.MediaProjectionManager

val Context.mediaSessionManager: android.media.session.MediaSessionManager
    get() = getSystemService(Context.MEDIA_SESSION_SERVICE) as android.media.session.MediaSessionManager

val Context.midiManager: android.media.midi.MidiManager
    get() = getSystemService(Context.MIDI_SERVICE) as android.media.midi.MidiManager

val Context.networkStatsManager: android.app.usage.NetworkStatsManager
    get() = getSystemService(Context.NETWORK_STATS_SERVICE) as android.app.usage.NetworkStatsManager

val Context.nfcManager: android.nfc.NfcManager
    get() = getSystemService(Context.NFC_SERVICE) as android.nfc.NfcManager

val Context.notificationManager: android.app.NotificationManager
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager

val Context.nsdManager: android.net.nsd.NsdManager
    get() = getSystemService(Context.NSD_SERVICE) as android.net.nsd.NsdManager

val Context.powerManager: android.os.PowerManager
    get() = getSystemService(Context.POWER_SERVICE) as android.os.PowerManager

val Context.printManager: android.print.PrintManager
    get() = getSystemService(Context.PRINT_SERVICE) as android.print.PrintManager

val Context.restrictionsManager: android.content.RestrictionsManager
    get() = getSystemService(Context.RESTRICTIONS_SERVICE) as android.content.RestrictionsManager

val Context.searchManager: android.app.SearchManager
    get() = getSystemService(Context.SEARCH_SERVICE) as android.app.SearchManager

val Context.sensorManager: android.hardware.SensorManager
    get() = getSystemService(Context.SENSOR_SERVICE) as android.hardware.SensorManager

val Context.storageManager: android.os.storage.StorageManager
    get() = getSystemService(Context.STORAGE_SERVICE) as android.os.storage.StorageManager

val Context.telecomManager: android.telecom.TelecomManager
    get() = getSystemService(Context.TELECOM_SERVICE) as android.telecom.TelecomManager

val Context.telephonyManager: android.telephony.TelephonyManager
    get() = getSystemService(Context.TELEPHONY_SERVICE) as android.telephony.TelephonyManager

val Context.tvInputManager: android.media.tv.TvInputManager
    get() = getSystemService(Context.TV_INPUT_SERVICE) as android.media.tv.TvInputManager

val Context.uiModeManager: android.app.UiModeManager
    get() = getSystemService(Context.UI_MODE_SERVICE) as android.app.UiModeManager

val Context.usageStatsManager: android.app.usage.UsageStatsManager
    get() = getSystemService(Context.USAGE_STATS_SERVICE) as android.app.usage.UsageStatsManager

val Context.usbManager: android.hardware.usb.UsbManager
    get() = getSystemService(Context.USB_SERVICE) as android.hardware.usb.UsbManager

val Context.userManager: android.os.UserManager
    get() = getSystemService(Context.USER_SERVICE) as android.os.UserManager

val Context.wallpaperManager: android.app.WallpaperManager
    get() = getSystemService(Context.WALLPAPER_SERVICE) as android.app.WallpaperManager

val Context.wifiP2pManager: android.net.wifi.p2p.WifiP2pManager
    get() = getSystemService(Context.WIFI_P2P_SERVICE) as android.net.wifi.p2p.WifiP2pManager

val Context.wifiManager: android.net.wifi.WifiManager
    get() = getSystemService(Context.WIFI_SERVICE) as android.net.wifi.WifiManager

val Context.windowManager: android.view.WindowManager
    get() = getSystemService(Context.WINDOW_SERVICE) as android.view.WindowManager