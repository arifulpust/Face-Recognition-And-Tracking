package ocuiparts.com.library.customView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ocuiparts.com.library.Interface.HeaderItemClickListener;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.View.YuGothicTextView;

/**
 * Created by mdmunirhossain on 4/19/18.
 */

public class CustomHeaderView extends LinearLayout {

    private FrameLayout main_frame;
    private FrameLayout point_frame;

    private RelativeLayout mainView;
    private Bitmap bm_right_icon;
    private Bitmap bm_left_icon;
    private Bitmap bm_left_point;
    private int right_icon;
    private int left_icon;

    private int left_point_icon;
    private boolean dropShadow;
    private boolean right_icon_visibility;
    private boolean left_icon_visibility;
    private boolean left_point_visibility;
    private View dropShadowView;
    private AppCompatImageButton btn_header_right;
    private AppCompatImageButton btn_header_left;
    private YuGothicTextView tv_title;
    private YuGothicTextView tv_point;
    private YuGothicTextView pt_text;
    private ImageView image_point;

    private int text_color = R.color.black;
    private int point_text_color = R.color.colorAccentNew;

    private int title_textSize;
    private int point_textSize;

    private String title_text;
    private String point_text;

    private boolean title_visible;
    private HeaderItemClickListener headerItemClickListener;

    public CustomHeaderView(Context context) {
        super(context);
    }

    @SuppressLint("ResourceAsColor")
    public CustomHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomHeaderView, 0, 0);

        try {
            // get the text and colors specified using the names in attrs.xml
            title_visible = a.getBoolean(R.styleable.CustomHeaderView_title_visible, false);
            title_text = a.getString(R.styleable.CustomHeaderView_title_text);
            point_text = a.getString(R.styleable.CustomHeaderView_point_text);

            title_textSize = a.getDimensionPixelSize(R.styleable.CustomHeaderView_title_textSize, 26);
            point_textSize = a.getDimensionPixelSize(R.styleable.CustomHeaderView_point_textSize, 50);
            text_color = a.getColor(R.styleable.CustomHeaderView_text_color, text_color);

            point_text_color = a.getColor(R.styleable.CustomHeaderView_point_text_color, point_text_color);
            left_icon_visibility = a.getBoolean(R.styleable.CustomHeaderView_left_icon_visibility, false);
            right_icon_visibility = a.getBoolean(R.styleable.CustomHeaderView_right_icon_visibility, false);
            left_point_visibility = a.getBoolean(R.styleable.CustomHeaderView_left_point_visibility, false);
            dropShadow = a.getBoolean(R.styleable.CustomHeaderView_dropShadow, false);


            left_icon = a.getResourceId(R.styleable.CustomHeaderView_left_icon, 0);
            right_icon = a.getResourceId(R.styleable.CustomHeaderView_right_icon, 0);
            left_point_icon = a.getResourceId(R.styleable.CustomHeaderView_left_point, 0);

            bm_left_icon = BitmapFactory.decodeResource(getResources(), left_icon);
            bm_right_icon = BitmapFactory.decodeResource(getResources(), right_icon);
            bm_left_point = BitmapFactory.decodeResource(getResources(), left_point_icon);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.custom_header_layout, this);
        mainView = (RelativeLayout) this.findViewById(R.id.mainView);
        tv_title = (YuGothicTextView) this.findViewById(R.id.tv_title);


        main_frame = (FrameLayout) this.findViewById(R.id.framelayout);
        point_frame = (FrameLayout) this.findViewById(R.id.framelayout_point);

        tv_point= (YuGothicTextView) this.findViewById(R.id.tv_point);
        pt_text= (YuGothicTextView) this.findViewById(R.id.pt_text);
        image_point=(ImageView) this.findViewById(R.id.img);

        image_point=(ImageView) this.findViewById(R.id.img);



        btn_header_right = (AppCompatImageButton) this.findViewById(R.id.btn_header_right);
        btn_header_left = (AppCompatImageButton) this.findViewById(R.id.btn_header_left);
        dropShadowView = (View) this.findViewById(R.id.dropShadow);

        //setUp the title text
        if (title_visible) {
            setText(title_text);
            setTextSize(title_textSize);
            setLeftPointText(point_text);
            setLeftPointTextSize(point_textSize);
            setLeftPointTextColor(point_text_color);
            setVisible(true);
            setTextColor(text_color);

        } else {
            setVisible(false);
        }

        left_point_icon_visible(left_point_visibility);
        left_icon_visible(left_icon_visibility);
        right_icon_visible(right_icon_visibility);
        setDropShadow(dropShadow);

        tv_title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (headerItemClickListener != null)
                    headerItemClickListener.onTitleClick();
            }
        });
        btn_header_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (headerItemClickListener != null)
                    headerItemClickListener.onLeftItemClick();
            }
        });
        btn_header_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (headerItemClickListener != null)
                    headerItemClickListener.onRightItemClick();
            }
        });
    }

    public void setHeaderItemClickListener(HeaderItemClickListener listener) {
        this.headerItemClickListener = listener;
    }

    public void setDropShadow(boolean dropShadobw) {
        if (dropShadobw)
            dropShadowView.setVisibility(VISIBLE);
        else
            dropShadowView.setVisibility(GONE);

    }

    public CustomHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void left_icon_visible(boolean visible) {
        if (visible) {
            main_frame.setVisibility(VISIBLE);
            if (bm_left_icon != null) {
                btn_header_left.setImageBitmap(bm_left_icon);
            }
        } else {
            main_frame.setVisibility(INVISIBLE);
        }
    }

    public void left_point_icon_visible(boolean visible) {
        if (visible) {
            point_frame.setVisibility(VISIBLE);
            if (bm_left_point != null) {
                image_point.setImageBitmap(bm_left_point);
            }
        } else {
            point_frame.setVisibility(INVISIBLE);
        }
    }



    public void right_icon_visible(boolean visible) {
        if (visible) {
            btn_header_right.setVisibility(VISIBLE);
            if (bm_right_icon != null) {
                btn_header_right.setImageBitmap(bm_right_icon);
            }
        } else {
            btn_header_right.setVisibility(INVISIBLE);
        }
    }





    public void setVisible(boolean visible) {
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
    public void setText(String title_text) {
        tv_title.setText(title_text);
    }

    public void setBackgrndColor(int hdrBkgrdCol) {
        mainView.setBackgroundColor(hdrBkgrdCol);
        mainView.setBackgroundResource(hdrBkgrdCol);
    }
    public void setLeftPointText(String title_text) {
        tv_point.setText(title_text);
    }

    public void setLeftPointTextSize(int text_size) {

        if(text_size>50) {

            text_size = 50;
        }
            tv_point.setTextSize(text_size);
            tv_point.setTag(String.valueOf(text_size));

    }

    public void setLeftPointTextColor(int color) {
        tv_point.setTextColor(color);
    }

}
