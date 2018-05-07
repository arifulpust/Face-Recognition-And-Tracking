package ocuiparts.com.library.View;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import ocuiparts.com.library.MyMultiDexApplication;

/**
 * Created by MinhTD on 2017/09/13.
 */

public class YuGothicMediumTextView extends AppCompatTextView {

    public YuGothicMediumTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        callSetTypeface();
    }

    public YuGothicMediumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        callSetTypeface();
    }

    public YuGothicMediumTextView(Context context) {
        super(context);
        callSetTypeface();
    }

    private void callSetTypeface(){
        setTypeface(getTypeface(), getTypeface().getStyle());
        setIncludeFontPadding(false);
        if(getMaxLines()>1) {
            setLineSpacing(1.0f, 1.4f);
        }
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        if (MyMultiDexApplication.mTfMedium != null) {
            super.setTypeface(MyMultiDexApplication.mTfMedium, style);
        } else {
            super.setTypeface(tf, style);
        }
    }
}
