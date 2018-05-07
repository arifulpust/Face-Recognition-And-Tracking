package ocuiparts.com.library.customButtons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;

import ocuiparts.com.library.R;
import ocuiparts.com.library.View.YuGothicButton;

/**
 * Created by mdmunirhossain on 4/19/18.
 */

public class CustomSubmitButton extends YuGothicButton {

    private int forground_drawable;
    private int background_drawable;
    private int background_color = R.color.transparent;
    private int border_color = R.color.transparent;
    private int border_width = 0;
    private int corner_radius = 0;

    public CustomSubmitButton(Context context) {
        super(context);
    }

    @SuppressLint("ResourceAsColor")
    public CustomSubmitButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomSubmitButton, 0, 0);
        try {
            // get the text and colors specified using the names in attrs.xml
            background_color = a.getColor(R.styleable.CustomSubmitButton_background_color, 0);
            border_color = a.getColor(R.styleable.CustomSubmitButton_border_color, border_color);
            corner_radius = a.getDimensionPixelSize(R.styleable.CustomSubmitButton_corner_radius, corner_radius);
            border_width = a.getDimensionPixelSize(R.styleable.CustomSubmitButton_border_width, border_width);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.recycle();
        }
        setUpView();

    }

    private void setUpView() {
        if(background_color != 0)
            setBorderRadius(background_color, corner_radius, border_color, border_width);
    }

    public CustomSubmitButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
}
