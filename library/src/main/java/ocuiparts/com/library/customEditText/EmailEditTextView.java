package ocuiparts.com.library.customEditText;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

import ocuiparts.com.library.MyMultiDexApplication;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;

/**
 * Created by mdmunirhossain on 2/28/18.
 */

public class EmailEditTextView extends LinearLayout {
    private LinearLayout main_layout;
    private LinearLayout layout_et;
    private EditText et_main;

    private int text_size_default = 26;
    private int text_size_et;
    private String hint_et;
    private int placeholder_color;
    private int cursor_color;
    private int border_width = 0;

    private int text_color_et = R.color.common_black_15;
    private int border_color = R.color.white;
    private int hint_color_et = android.R.color.holo_blue_light;
    private int placeholder_color_et = R.color.white;
    private int corner_radius_border = 0;

    private int lines = 1;
    private int max_lines = 1;
    private Context context;

    public EmailEditTextView(Context context) {
        super(context);
    }

    @SuppressLint("ResourceAsColor")
    public EmailEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.EmailEditTextView, 0, 0);
        this.context = context;
        try {
            // get the text and colors specified using the names in attrs.xml
            //sizes in pixels
            border_width = a.getDimensionPixelSize(R.styleable.EmailEditTextView_border_width, border_width);
            text_size_et = a.getDimensionPixelSize(R.styleable.EmailEditTextView_text_size_et, text_size_default);
            corner_radius_border = a.getDimensionPixelSize(R.styleable.EmailEditTextView_corner_radius, corner_radius_border);
            //hint text
            hint_et = a.getString(R.styleable.EmailEditTextView_hint_et);
            //color values
            hint_color_et = a.getColor(R.styleable.EmailEditTextView_hint_color_et, hint_color_et);
            text_color_et = a.getColor(R.styleable.EmailEditTextView_text_color_et, text_color_et);
            placeholder_color = a.getColor(R.styleable.EmailEditTextView_placeholder_color, placeholder_color_et);
            cursor_color = a.getColor(R.styleable.EmailEditTextView_cursor_color, hint_color_et);
            border_color = a.getColor(R.styleable.EmailEditTextView_border_color, border_color);

            //lines
            lines = a.getInt(R.styleable.EmailEditTextView_lines, 1);
            max_lines = a.getInt(R.styleable.EmailEditTextView_max_lines, 1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.recycle();
        }
        LayoutInflater.from(context).inflate(R.layout.custom_edittext_layout, this);
        et_main = (EditText) this.findViewById(R.id.et_main);
        main_layout = (LinearLayout) this.findViewById(R.id.main_layout);
        layout_et = (LinearLayout) this.findViewById(R.id.layout_et);

        setupViews();

    }

    private void setupViews() {
        callSetTypeface();
        setBackgroundColor(placeholder_color);
        setCursorColor(et_main, cursor_color);
        setBorderColor(border_color);
        setBorderWidth(border_width);
        setHint(hint_et, hint_color_et);
        setTextProperties(text_color_et, text_size_et);
        setBorderRadius(corner_radius_border, border_color, border_width);
        setLines(lines);
        setMaxLines(max_lines);
    }


    public void setBackgroundColor(int color){
        placeholder_color = color;
        et_main.setBackgroundColor(placeholder_color);

    }

    public void setMaxLines(int max_lines) {
        this.et_main.setMaxLines(max_lines);
    }

    public void setLines(int lines) {
        this.et_main.setLines(lines);
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

    public void setHint(String hint_et, int hint_color_et) {
        this.hint_et = hint_et;
        this.hint_color_et = hint_color_et;
        if (et_main != null) {
            et_main.setHint(hint_et);
            et_main.setHintTextColor(hint_color_et);
        }
    }

    public void resizeTextField(Activity activity){
        CorrectSizeUtil.getInstance(activity).correctSizeByLayout(et_main);
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

    public EmailEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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


    public void setEditTextForCorners() {
        if (et_main != null) {
            GradientDrawable shape = new GradientDrawable();
            shape.setCornerRadius(corner_radius_border);
            shape.setColor(placeholder_color);
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


}
