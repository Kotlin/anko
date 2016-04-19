package android.content;

import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

public abstract class Context {
    public static final String UI_MODE_SERVICE = "uimode";

    // This method is marked as hidden in Android Context
    public abstract int getThemeResId();

    public abstract void startActivity(Intent intent);
    public abstract ComponentName startService(Intent service);
    public abstract String getString(int resId);
    public abstract Resources getResources();
    public abstract AssetManager getAssets();
    public abstract PackageManager getPackageManager();
    public abstract Object getSystemService(String name);
}
