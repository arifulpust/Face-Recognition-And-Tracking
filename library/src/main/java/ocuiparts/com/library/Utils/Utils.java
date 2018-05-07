package ocuiparts.com.library.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Calendar;
import java.util.TimeZone;


/**
 * Created by WIN-HAIVM on 7/6/17.
 */

public class Utils {
    private static final int SERVER_TIME_ZONE = 9;

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static CharSequence getStringData(String data) {
        if ((data != null) && (!TextUtils.isEmpty(data)) && (!data.equals("null"))) {
            return getFromHtml(data);
        }
        return "";
    }

    public static CharSequence getFromHtml(String data) {
        if (Build.VERSION.SDK_INT < 24) {
            return Html.fromHtml(data);
        } else {
            return Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY);
        }
    }

    public static String getDateFromSecond(long second) {
        try {
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            cal.setTimeInMillis(getTimeInZone(second));
            String res = "";
            res += cal.get(Calendar.YEAR);
            res += "." + String.format("%02d", (cal.get(Calendar.MONTH) + 1));
            res += "." + String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH)));
            return res;
        } catch (Exception e) {
            return "-";
        }
    }

    private static long getTimeInZone(long second) {
        return (SERVER_TIME_ZONE * 3600 + second) * 1000;
    }

}
