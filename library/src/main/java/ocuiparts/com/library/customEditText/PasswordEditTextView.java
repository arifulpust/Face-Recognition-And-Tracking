package ocuiparts.com.library.customEditText;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

import ocuiparts.com.library.MyMultiDexApplication;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;

/**
 * Created by mdmunirhossain on 2/28/18.
 */

public class PasswordEditTextView extends LinearLayout {
    private LinearLayout main_layout;
    private LinearLayout layout_et;
    private EditText et_main;
    private ImageView image;

    private Bitmap password_visibility_on_icon;
    private Bitmap password_visibility_off_icon;
    private int on_icon;
    private int off_icon;

    private int text_size_default = 22;
    private int text_size_et;
    private String hint_et;
    private int placeholder_color= R.color.white;
    private int cursor_color= R.color.colorAccent;;
    private int border_width = 0;

    private int text_color_et = R.color.common_black_15;
    private int border_color = R.color.white;
    private int hint_color_et = R.color.main_gray_color;
    private int corner_radius_border = 0;
    int flagImage = 0;




    public PasswordEditTextView(Context context) {
        super(context);
    }

    public PasswordEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.PasswordEditTextView, 0, 0);

        try {
            // get the text and colors specified using the names in attrs.xml
            border_width = a.getInt(R.styleable.PasswordEditTextView_border_width, border_width);
            hint_et = a.getString(R.styleable.PasswordEditTextView_hint_pass);
            text_size_et = a.getInt(R.styleable.PasswordEditTextView_text_size_pass, text_size_default);
            corner_radius_border = a.getInt(R.styleable.PasswordEditTextView_corner_radius_border_pass, corner_radius_border);
            hint_color_et = a.getInt(R.styleable.PasswordEditTextView_hint_color_pass, hint_color_et);
            text_color_et = a.getInt(R.styleable.PasswordEditTextView_text_color_pass, text_color_et);
            placeholder_color = a.getInt(R.styleable.PasswordEditTextView_placeholder_color_pass, placeholder_color);
            cursor_color = a.getInt(R.styleable.PasswordEditTextView_cursor_color_pass, cursor_color);
            border_color = a.getInt(R.styleable.PasswordEditTextView_border_color, border_color);

            on_icon = a.getResourceId(R.styleable.PasswordEditTextView_password_visibility_icon_on,0);
            off_icon = a.getResourceId(R.styleable.PasswordEditTextView_password_visibility_icon_off, 0);

            password_visibility_on_icon = BitmapFactory.decodeResource(getResources(), on_icon);
            password_visibility_off_icon = BitmapFactory.decodeResource(getResources(), off_icon);

        } finally {
            a.recycle();
        }
        LayoutInflater.from(context).inflate(R.layout.password_edittext, this);
        et_main = (EditText) this.findViewById(R.id.et_main);
        main_layout = (LinearLayout) this.findViewById(R.id.main_layout);
        layout_et = (LinearLayout) this.findViewById(R.id.layout_et);
        image = (ImageView) this.findViewById(R.id.img1);



        setPasswordVisibiltyIconOff(getResources().getDrawable(R.drawable.ic_btn_password_off));
      //  image.setImageDrawable(password_visibility_off_icon);

        et_main.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);


        et_main.setBackgroundColor(getResources().getColor(placeholder_color));
        callSetTypeface();
        setCursorColor(et_main, getResources().getColor(cursor_color));
        setBorderColor(border_color);
        setBorderWidth(border_width);
        setHintPassword(hint_et, hint_color_et);
        setTextProperties(text_color_et, text_size_et);
        setBorderRadius(corner_radius_border, border_color, border_width);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_main.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    et_main.setInputType( InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);


                    //    image.setImageBitmap(password_visibility_off_icon);


                    setPasswordVisibiltyIconOff(getResources().getDrawable(R.drawable.ic_btn_password_off));


                }else {
                    et_main.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );


                     //   image.setImageBitmap(password_visibility_on_icon);



                    setPasswordVisibiltyIconOff(getResources().getDrawable(R.drawable.ic_btn_password_on));


                }
                et_main.setSelection(et_main.getText().length());
            }
        });
    }

    public void setTextProperties(int text_color_et, int text_size_et) {
        this.text_color_et = text_color_et;
        this.text_size_et = text_size_et;
        if (et_main != null) {
            et_main.setTextColor(text_color_et);
            et_main.setTextSize(text_size_et);
            et_main.setTag(String.valueOf(text_size_et));
        }
    }


    public void setMaxLines(int max_lines) {
        this.et_main.setMaxLines(max_lines);
    }

    public void setLines(int lines) {
        this.et_main.setLines(lines);
    }

    public void resizeTextField(Activity activity){
        CorrectSizeUtil.getInstance(activity).correctSizeByLayout(et_main);
    }

    public void setHintPassword(String hint_et, int hint_color_et) {
        this.hint_et = hint_et;
        this.hint_color_et = hint_color_et;
        if (et_main != null) {
            et_main.setHint(hint_et);
            et_main.setHintTextColor(hint_color_et);
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

    public PasswordEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPlaceholder_color(int color) {
        this.placeholder_color = color;
        if (this != null) {
            this.setBackgroundColor(color);
        }
    }

    public void setCursor_color(int color) {
        this.cursor_color = color;
        if (et_main != null) {
            setCursorColor(et_main, color);
        }
    }

    public static void setCursorColor(EditText view, @ColorInt int color) {
        try {
            // Get the cursor resource id
            Field field = TextView.class.getDeclaredField("mCursorDrawableRes");
            field.setAccessible(true);
            int drawableResId = field.getInt(view);

            // Get the editor
            field = TextView.class.getDeclaredField("mEditor");
            field.setAccessible(true);
            Object editor = field.get(view);

            // Get the drawable and set a color filter
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), drawableResId);
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            Drawable[] drawables = {drawable, drawable};

            // Set the drawables
            field = editor.getClass().getDeclaredField("mCursorDrawable");
            field.setAccessible(true);
            field.set(editor, drawables);
        } catch (Exception ignored) {
        }
    }

    public void setBorderRadius(int corner_radius_border, int border_color, int border_width) {
        this.corner_radius_border = corner_radius_border;
        if (main_layout != null) {
            GradientDrawable shape = new GradientDrawable();
            shape.setCornerRadius(corner_radius_border);
            shape.setStroke(border_width, border_color);
            shape.setColor(border_color);
            shape.setStroke(1, border_color);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                main_layout.setBackground(shape);
            } else {
                main_layout.setBackgroundDrawable(shape);
            }

            setEditTextForCorners();
        }
    }

    private void setEditTextForCorners() {
        if (et_main != null) {
            GradientDrawable shape = new GradientDrawable();
            shape.setCornerRadius(corner_radius_border);
            shape.setColor(getResources().getColor(placeholder_color));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                et_main.setBackground(shape);
            } else {
                et_main.setBackgroundDrawable(shape);
            }
        }
    }

    private void callSetTypeface() {
        et_main.setIncludeFontPadding(false);
        if (MyMultiDexApplication.mTfMedium != null) {
            et_main.setTypeface(MyMultiDexApplication.mTfMedium, et_main.getTypeface().getStyle());
        } else {
            et_main.setTypeface(et_main.getTypeface(), et_main.getTypeface().getStyle());
        }
    }

    public void setPasswordVisibiltyIconOn(Drawable bitmap) {

        image.setImageDrawable(bitmap);
    }

    public void setPasswordVisibiltyIconOff(Drawable bitmap) {

        image.setImageDrawable(bitmap);

    }



}
