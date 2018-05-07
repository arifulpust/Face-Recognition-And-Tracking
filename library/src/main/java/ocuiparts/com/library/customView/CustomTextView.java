package ocuiparts.com.library.customView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import ocuiparts.com.library.MyMultiDexApplication;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;

/**
 * Created by mdmunirhossain on 4/18/18.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    private int background_color = R.color.transparent;
    private int border_color = R.color.transparent;
    private int border_width = 0;
    private int corner_radius = 0;

    public CustomTextView(Context context) {
        super(context);
        callSetTypeface();
    }

    @SuppressLint("ResourceAsColor")
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        callSetTypeface();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomImageView, 0, 0);

        try {
            // get the text and colors specified using the names in attrs.xml
            border_color = a.getColor(R.styleable.CustomTextView_border_color, border_color);
            border_width = a.getDimensionPixelSize(R.styleable.CustomTextView_border_width, border_width);
            corner_radius = a.getDimensionPixelSize(R.styleable.CustomTextView_corner_radius, corner_radius);
            background_color = a.getColor(R.styleable.CustomTextView_background_color, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.recycle();
        }

        setUpView();

    }

    private void setUpView() {
        if (background_color != 0)
            setBorderRadius(background_color, corner_radius, border_color, border_width);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        callSetTypeface();
    }

    //setUp yougothic font
    private void callSetTypeface() {
        setTypeface(getTypeface(), getTypeface().getStyle());
        setIncludeFontPadding(false);
        if (getLineSpacingMultiplier() == 1.2f) {
            return;
        }
        if (getMaxLines() > 1) {
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

    public void setBorderRadius(int background_color, int corner_radius_border, int border_color, int border_width) {
        GradientDrawable shape = new GradientDrawable();
        shape.setCornerRadius(corner_radius_border);
        shape.setStroke(border_width, border_color);
        shape.setColor(background_color);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(shape);
        } else {
            this.setBackgroundDrawable(shape);
        }

    }

    public void setTextProperties(int text_color_et, int text_size_et) {
        this.setTextColor(text_color_et);
        this.setTextSize(text_size_et);
        this.setTag(String.valueOf(text_size_et));
    }

    public void resizeTextField(Activity activity){
        CorrectSizeUtil.getInstance(activity).correctSize(this);
    }
}
