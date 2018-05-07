package ocuiparts.com.library.customView;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import ocuiparts.com.library.Interface.HeaderItemClickListener;
import ocuiparts.com.library.R;
import ocuiparts.com.library.View.YuGothicTextView;

/**
 * Created by HP on 4/26/2018.
 */

public class CustomChatCellView extends LinearLayout {


    private RelativeLayout mainView;
    private YuGothicTextView upper_left_tv;
    private YuGothicTextView bottom_left_tv;
    private YuGothicTextView upper_right_tv;

    private YuGothicTextView banner_text_tv;



    private ImageView left_icon_imageView;
    private Bitmap bm_right_icon;
    //  private Bitmap bm_left_icon;
    private int upper_left_text_color = R.color.black;
    private int upper_right_text_color = R.color.black;
    private int bottom_left_text_color = R.color.black;


    private int banner_text_color = R.color.white;


    private int upper_left_textSize;
    private int upper_right_textSize;
    private int bottom_left_textSize;
    private int left_icon;
    private String upper_left_text;
    private String bottom_left_text;
    private String upper_right_text;
    private String banner_text;


    private boolean upper_left_text_visible;
    private boolean upper_right_text_visible;
    private boolean bottom_left_text_visible;
    private Bitmap bm_left_icon;

    private HeaderItemClickListener headerItemClickListener;

    public CustomChatCellView(Context context) {
        super(context);
    }

    @SuppressLint("ResourceAsColor")
    public CustomChatCellView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomCellView, 0, 0);

        try {
            // get the text and colors specified using the names in attrs.xml

            upper_left_text_visible = a.getBoolean(R.styleable.CustomCellView_upper_left_text_visibility, false);
            bottom_left_text_visible = a.getBoolean(R.styleable.CustomCellView_bottom_left_text_visibility, false);
            upper_right_text_visible = a.getBoolean(R.styleable.CustomCellView_upper_right_text_visibility, false);


            upper_left_text = a.getString(R.styleable.CustomCellView_upper_left_text);
            bottom_left_text = a.getString(R.styleable.CustomCellView_bottom_left_text);
            upper_right_text = a.getString(R.styleable.CustomCellView_upper_right_text);

            banner_text= a.getString(R.styleable.CustomCellView_banner_text);

            upper_left_textSize = a.getDimensionPixelSize(R.styleable.CustomCellView_upper_left_text_size, 26);
            upper_right_textSize = a.getDimensionPixelSize(R.styleable.CustomCellView_upper_right_text_size, 26);
            bottom_left_textSize = a.getDimensionPixelSize(R.styleable.CustomCellView_bottom_left_text_size, 26);


            upper_left_text_color = a.getColor(R.styleable.CustomCellView_upper_left_text_color, upper_left_text_color);
            upper_right_text_color = a.getColor(R.styleable.CustomCellView_upper_right_text_color, upper_right_text_color);
            bottom_left_text_color = a.getColor(R.styleable.CustomCellView_bottom_left_text_color, bottom_left_text_color);

            banner_text_color= a.getColor(R.styleable.CustomCellView_banner_text_color,banner_text_color);


            left_icon = a.getResourceId(R.styleable.CustomCellView_left_icon_cell, 0);
            bm_left_icon = BitmapFactory.decodeResource(getResources(), left_icon);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.recycle();
        }


        LayoutInflater.from(context).inflate(R.layout.custom_cell_view, this);
        mainView = (RelativeLayout) this.findViewById(R.id.mainView);
        upper_left_tv = (YuGothicTextView) this.findViewById(R.id.upper_left);
        bottom_left_tv = (YuGothicTextView) this.findViewById(R.id.bottom_left);
        upper_right_tv = (YuGothicTextView) this.findViewById(R.id.upper_right);
        left_icon_imageView = (ImageView) this.findViewById(R.id.icon);
        banner_text_tv= (YuGothicTextView) this.findViewById(R.id.txt_banner);




        setUpperLeftText(upper_left_text);
        setUpperRightText(upper_right_text);
        setBottomLeftText(bottom_left_text);

        setBannerText(banner_text);


        setUpper_left_textSize(upper_left_textSize);
        setUpper_right_textSize(upper_right_textSize);
        setBottom_left_textSize(bottom_left_textSize);



        upper_left_text_visible(upper_left_text_visible);
        upper_right_text_visible(upper_right_text_visible);
        bottom_left_text_visible(bottom_left_text_visible);


        setUpper_left_textColor(getResources().getColor(R.color.black));
        setUpper_right_textColor(getResources().getColor(R.color.black));
        setBottom_left_textColor(getResources().getColor(R.color.black));


        set_icon();

    }


    public void set_icon() {

        if(bm_left_icon!=null) {

            left_icon_imageView.setImageBitmap(bm_left_icon);
        }

    }


    public void setHeaderItemClickListener(HeaderItemClickListener listener) {
        this.headerItemClickListener = listener;
    }


    public void upper_left_text_visible(boolean visible) {
        if (visible) {

            upper_left_tv.setVisibility(VISIBLE);

        } else {
            upper_left_tv.setVisibility(INVISIBLE);
        }
    }


    public void upper_right_text_visible(boolean visible) {
        if (visible) {

            upper_right_tv.setVisibility(VISIBLE);

        } else {
            upper_right_tv.setVisibility(INVISIBLE);
        }
    }

    public void bottom_left_text_visible(boolean visible) {
        if (visible) {

            bottom_left_tv.setVisibility(VISIBLE);

        } else {
            bottom_left_tv.setVisibility(INVISIBLE);
        }
    }



    public CustomChatCellView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomChatCellView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }



    public void setUpperLeftText(String title_text) {
        upper_left_tv.setText(title_text);
    }

    public void setUpperRightText(String title_text) {
        upper_right_tv.setText(title_text);
    }

    public void setBottomLeftText(String title_text) {
        bottom_left_tv.setText(title_text);
    }

    public void setUpper_left_textSize(int title_size) {
        upper_left_tv.setTextSize(title_size);
        upper_left_tv.setTag(String.valueOf(title_size));
    }

    public void setUpper_right_textSize(int title_size) {
        upper_right_tv.setTextSize(title_size);
        upper_right_tv.setTag(String.valueOf(title_size));
    }
    public void setBottom_left_textSize(int title_size) {
        bottom_left_tv.setTextSize(title_size);
        bottom_left_tv.setTag(String.valueOf(title_size));
    }




    public void setUpper_left_textColor(int title_size) {
        upper_left_tv.setTextColor(title_size);
        upper_left_tv.setTag(String.valueOf(title_size));
    }

    public void setUpper_right_textColor(int title_size) {
        upper_right_tv.setTextColor(title_size);
        upper_right_tv.setTag(String.valueOf(title_size));
    }


    public void setBottom_left_textColor(int title_size) {
        bottom_left_tv.setTextColor(title_size);
        bottom_left_tv.setTag(String.valueOf(title_size));
    }

    public void setBannerText(String title_text) {
        banner_text_tv.setText(title_text);
    }



}


