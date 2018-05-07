package ocuiparts.com.library.View;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.text.style.ReplacementSpan;

import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;

/**
 * Created by MinhTD on 2017/09/15.
 */

public class RoundedBackgroundSpan extends ReplacementSpan {
    private int mTextColor = 0;
    private int mBackground = 0;
    private Activity mActivity = null;
    //this param is 1/2 of padding of txt_category JobDetailFragment
    private static int sPadding = 10;
    private float mPadding;
    private static int sHeight = 0;
    public RoundedBackgroundSpan(Activity activity) {
        super();
        mActivity = activity;
        mTextColor = ContextCompat.getColor(mActivity, R.color.white);
        mBackground = ContextCompat.getColor(mActivity,R.color.job_introduction_category);
        mPadding = sPadding* CorrectSizeUtil.getInstance(mActivity).getScreenRateByMultiScreen();
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float right;
        RectF rect;
        right =  x + measureText(paint, text, start, end);
        mPadding = CorrectSizeUtil.getInstance(mActivity).getScreenRateByMultiScreen()*sPadding;
        float realBottom = top + mPadding*2 +(CorrectSizeUtil.getInstance(mActivity).getScreenRateByMultiScreen()*20);
        rect = new RectF(x, top, right, realBottom);
        paint.setColor(mBackground);
        canvas.drawRect(rect, paint);
        paint.setColor(mTextColor);

        canvas.drawText(text, start, end, x,realBottom - mPadding, paint);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return Math.round(paint.measureText(text, start, end));
    }

    private float measureText(Paint paint, CharSequence text, int start, int end) {
        return paint.measureText(text, start, end);
    }
}
