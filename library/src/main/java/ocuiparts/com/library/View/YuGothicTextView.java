package ocuiparts.com.library.View;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import ocuiparts.com.library.MyMultiDexApplication;

/**
 * Created by WIN-HAIVM on 7/24/17.
 */

public class YuGothicTextView extends AppCompatTextView {
//    Typeface mTf = Typeface.createFromAsset(getContext().getAssets(), "yugothic.ttf");

    public YuGothicTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        callSetTypeface();
    }

    public YuGothicTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        callSetTypeface();
    }

    public YuGothicTextView(Context context) {
        super(context);
        callSetTypeface();
    }

    private void callSetTypeface() {
        setTypeface(getTypeface(), getTypeface().getStyle());
        setIncludeFontPadding(false);
        if(getLineSpacingMultiplier()==1.2f){
            return;
        }
        if(getMaxLines()>1) {
            setLineSpacing(1.0f, 1.4f);
        }
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        if (MyMultiDexApplication.mTf != null && style == Typeface.BOLD) {
            super.setTypeface(MyMultiDexApplication.mTf, style);
        } else if (MyMultiDexApplication.mTfMedium != null && style != Typeface.BOLD) {
            super.setTypeface(MyMultiDexApplication.mTfMedium, style);
        } else {
            super.setTypeface(tf, style);
        }
    }

//    @Override
//    public void setTypeface(Typeface tf, int style) {
//        if (MyMultiDexApplication.mTf != null && style == Typeface.BOLD) {
//            super.setTypeface(MyMultiDexApplication.mTf, style);
//        } else {
//            super.setTypeface(tf, style);
//        }
//    }
//}
}

