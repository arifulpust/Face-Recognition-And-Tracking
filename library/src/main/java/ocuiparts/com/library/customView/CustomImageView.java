package ocuiparts.com.library.customView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.View.YuGothicTextView;

/**
 * Created by mdmunirhossain on 3/1/18.
 */

public class CustomImageView extends LinearLayout {

    private int text_color = R.color.black;
    private int title_textSize;
    private String title_text;
    private boolean title_visible;
    private YuGothicTextView tv_title;
    private ImageView imageViewMain;
    private Bitmap bm;
    private int image;
    private LinearLayout main_layout;
    private LinearLayout image_layout;

    private int background_color = R.color.transparent;
    private int border_color = R.color.transparent;
    private int border_width = 0;
    private int corner_radius = 0;
    private Context context;

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("ResourceAsColor")
    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomImageView, 0, 0);
        this.context = context;
        try {
            // get the text and colors specified using the names in attrs.xml
            image = a.getResourceId(R.styleable.CustomImageView_image_main, 0);
            background_color = a.getColor(R.styleable.CustomImageView_background_color, background_color);
            border_color = a.getColor(R.styleable.CustomImageView_border_color, border_color);
            corner_radius = a.getDimensionPixelSize(R.styleable.CustomImageView_corner_radius, corner_radius);
            border_width = a.getDimensionPixelSize(R.styleable.CustomImageView_border_width, border_width);
            title_visible = a.getBoolean(R.styleable.CustomImageView_title_visible, false);
            title_text = a.getString(R.styleable.CustomImageView_title_text);
            title_textSize = a.getDimensionPixelSize(R.styleable.CustomImageView_title_textSize, 26);
            text_color = a.getColor(R.styleable.CustomImageView_text_color, text_color);
            bm = BitmapFactory.decodeResource(getResources(), image);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.custom_imageview_layout, this);
        imageViewMain = (ImageView) this.findViewById(R.id.image);
        main_layout = (LinearLayout) this.findViewById(R.id.main_layout);
        image_layout = (LinearLayout) this.findViewById(R.id.image_layout);
        tv_title = (YuGothicTextView) this.findViewById(R.id.tv_title);

        if (bm != null) {
            imageViewMain.setImageBitmap(bm);
        }
        setImageBackgroundColor(background_color);
        setBorderColor(border_color);
        setBorderWidth(border_width);
        setBorderRadius(corner_radius, border_color, border_width);


        //setUp the title text
        if (title_visible) {
            setText(title_text);
            setTextSize(title_textSize);
            settitleTextVisible(true);
            setTextColor(text_color);
        } else {
            settitleTextVisible(false);
        }

    }

    public void settitleTextVisible(boolean visible) {
        if (visible)
            tv_title.setVisibility(VISIBLE);
        else
            tv_title.setVisibility(INVISIBLE);
    }

    public void setTextColor(int color) {
        tv_title.setTextColor(color);
    }

    public void setTextSize(int title_textSize) {
        tv_title.setTextSize(title_textSize);
        tv_title.setTag(String.valueOf(title_textSize));

    }

    public void setTopMarginText(int matginTop){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(0,matginTop,0,0);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        tv_title.setLayoutParams(params);
    }

    public void resizeTextField(Activity activity){
        CorrectSizeUtil.getInstance(activity).correctSizeByLayout(tv_title);
    }


    public void setText(String title_text) {
        tv_title.setText(title_text);
    }


    public void setBorderRadius(int corner_radius_border, int border_color, int border_width) {
        this.corner_radius = corner_radius_border;
        if (main_layout != null) {
            GradientDrawable shape = new GradientDrawable();
            shape.setCornerRadius(corner_radius_border);
            shape.setStroke(border_width, border_color);
            shape.setColor(border_color);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                main_layout.setBackground(shape);
            } else {
                main_layout.setBackgroundDrawable(shape);
            }

            //setEditTextForCorners();
        }

    }


    public void setBorderWidth(int width) {
        border_width = width;
        if (main_layout != null)
            main_layout.setPadding(width, width, width, width);
    }

    public void setBorderColor(int color) {
        border_color = color;
        if (main_layout != null)
            main_layout.setBackgroundColor(color);
    }

    public void setImageBackgroundColor(int color) {
        background_color = color;
        if (image_layout != null) {
            image_layout.setBackgroundColor(color);
        }
    }

    public void setImage(Bitmap imageBitmap) {
        bm = imageBitmap;
        if (bm != null) {
            imageViewMain.setImageBitmap(bm);
        }
    }

}
