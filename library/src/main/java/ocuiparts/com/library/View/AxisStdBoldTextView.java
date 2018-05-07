package ocuiparts.com.library.View;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import ocuiparts.com.library.MyMultiDexApplication;


/**
 * Created by Giangnt on 10/12/17.
 */

public class AxisStdBoldTextView extends AppCompatTextView {
//    Typeface mTf = Typeface.createFromAsset(getContext().getAssets(), "yugothic.ttf");

    public AxisStdBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public AxisStdBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AxisStdBoldTextView(Context context) {
        super(context);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        if(MyMultiDexApplication.mTfAxisStdBold!=null) {
            super.setTypeface(MyMultiDexApplication.mTfAxisStdBold);
        }
        else{
            super.setTypeface(tf);
        }
    }
}

