package ocuiparts.com.library.View;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import ocuiparts.com.library.MyMultiDexApplication;

/**
 * Created by Giangnt on 8/28/2017.
 */

public class YuGothicMediumEditText extends AppCompatEditText {
    public YuGothicMediumEditText(Context context) {
        super(context);
        callSetTypeface();
    }

    public YuGothicMediumEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        callSetTypeface();
    }

    public YuGothicMediumEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        callSetTypeface();
    }

    private void callSetTypeface() {
        setTypeface(getTypeface(), getTypeface().getStyle());
        setIncludeFontPadding(false);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        if (MyMultiDexApplication.mTfMedium != null) {
            super.setTypeface(MyMultiDexApplication.mTf, style);
        } else {
            super.setTypeface(tf, style);
        }
    }
}
