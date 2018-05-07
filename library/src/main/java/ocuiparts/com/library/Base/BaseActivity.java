package ocuiparts.com.library.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatDelegate;

import ocuiparts.com.library.Utils.CorrectSizeUtil;


/**
 * Created by WIN-HAIVM on 7/6/17.
 */

public class BaseActivity extends FragmentActivity {
    // Firebase

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        resetCorrectSize();
    }
    private void resetCorrectSize() {
        CorrectSizeUtil.screenRate = 0;
    }
}


