package ocuiparts.com.library;

import android.graphics.Typeface;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by WIN-HAIVM on 7/5/17.
 */

public class MyMultiDexApplication extends MultiDexApplication {
    public static Typeface mTf;
    public static Typeface mTfMedium;
    public static Typeface mTfAxisStdBold;
    public static boolean sIsLoadingFavorite = false;
    public static boolean sIsMainStarted = false;
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        mTf = Typeface.createFromAsset(getAssets(), "yugothic.ttf");
        mTfMedium = Typeface.createFromAsset(getAssets(),"yugothicmedium.otf");
        mTfAxisStdBold = Typeface.createFromAsset(getAssets(), "axisstd-bold.otf");
    }

}
