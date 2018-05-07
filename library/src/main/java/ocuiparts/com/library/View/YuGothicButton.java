package ocuiparts.com.library.View;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import ocuiparts.com.library.MyMultiDexApplication;


/**
 * Created by Giangnt on 8/29/2017.
 */

public class YuGothicButton extends AppCompatButton {
    public YuGothicButton(Context context) {
        super(context);
        callSetTypeface();
    }

    public YuGothicButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        callSetTypeface();
    }

    public YuGothicButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        callSetTypeface();
    }

    private void callSetTypeface() {
        setTypeface(getTypeface(), getTypeface().getStyle());
        setIncludeFontPadding(false);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        if (MyMultiDexApplication.mTf != null) {
            super.setTypeface(MyMultiDexApplication.mTf, Typeface.BOLD);
        } else {
            super.setTypeface(tf);
        }
    }
}
