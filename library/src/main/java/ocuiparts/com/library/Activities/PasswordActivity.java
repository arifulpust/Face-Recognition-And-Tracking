package ocuiparts.com.library.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.EActivity;

import ocuiparts.com.library.Base.BaseActivity;
import ocuiparts.com.library.Interface.HeaderItemClickListener;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.customButtons.CustomSubmitButton;
import ocuiparts.com.library.customEditText.EmailEditTextView;
import ocuiparts.com.library.customView.CustomHeaderView;
import ocuiparts.com.library.customView.CustomTextView;

/**
 * Created by HP on 4/19/2018.
 */


@EActivity
public class PasswordActivity extends BaseActivity implements HeaderItemClickListener{
    // Header
    private CustomHeaderView headerView = null;
    private boolean hdrAdd = true;                     // Add header or not
    private ImageView hdrImg;                          // Header image
    private int hdrTxt = R.string.txt_header_password; // Header text
    private int hdrTxtCol = R.color.black;             // Header text color
    private int hdrBkgrdCol = R.color.white;           // Header background color
    private boolean isDropShadow = true;               // Add DropShadow or not
    private int hdrHt = 120;                           // Header height

    //Custom txt_intro label
    CustomTextView txt_intro = null;
    private boolean txt_introAdd = true;                               //add label password or not
    private int txt_intro_background_color = R.color.homeBackground;   // Background Color
    private int txt_intro_border_color = R.color.white;                // Border Color
    private int txt_intro_border_width = 0;                            // Border Width
    private int txt_intro_corner_radius = 0;                           // Border Corner radius
    private int txt_intro_textColor = R.color.gray_black;              // text Color
    private int txt_intro_textSize = 32;                               // text Size
    private int txt_intro_text = R.string.txt_password_intro_1;        // text


    //Custom EmailEditTextView
    EmailEditTextView edt_email = null;
    private boolean edt_emailAdd = true;                               // Add emailEdittext or not
    private boolean edt_emailHintAdd = true;                           // Add hint or not
    private String edt_emailHint = "メールアドレス";                      // Hint Text
    private int edt_emailHintColor = R.color.hint_color;               // Hint color
    private int edt_emailCursorColor = R.color.colorAccent;            // cursor color
    private int edt_email_background_color = R.color.white;            // Background Color
    private int edt_email_border_color = R.color.white;                // Border Color
    private int edt_email_border_width = 0;                            // Border Width
    private int edt_email_corner_radius = 0;                           // Border Corner radius
    private int edt_email_lines = 1;                                   // Lines
    private int edt_email_max_lines = 1;                               // max Lines
    private int edt_email_textColor = R.color.black;                   // text Color
    private int edt_email_textSize = 26;                               // text Size


    //Custom email label
    CustomTextView tv_email = null;
    private boolean tv_emailAdd = true;                               //add label email or not
    private int tv_email_background_color = R.color.white;            // Background Color
    private int tv_email_border_color = R.color.black;                // Border Color
    private int tv_email_border_width = 0;                            // Border Width
    private int tv_email_corner_radius = 0;                           // Border Corner radius
    private int tv_email_textColor = R.color.gray_black;              // text Color
    private int tv_email_textSize = 26;                               // text Size
    private int tv_email_text = R.string.login_email;                 // text


    //Custom EmailConfirmEditTextView
    EmailEditTextView edt_email_confirm = null;
    private boolean edt_email_confirmAdd = true;                               // Add emailEdittext or not
    private boolean edt_email_confirmHintAdd = true;                           // Add hint or not
    private String edt_email_confirmHint = "確認のためもう一度入力";               // Hint Text
    private int edt_email_confirmHintColor = R.color.hint_color;               // Hint color
    private int edt_email_confirmCursorColor = R.color.colorAccent;            // cursor color
    private int edt_email_confirm_background_color = R.color.white;            // Background Color
    private int edt_email_confirm_border_color = R.color.white;                // Border Color
    private int edt_email_confirm_border_width = 0;                            // Border Width
    private int edt_email_confirm_corner_radius = 0;                           // Border Corner radius
    private int lines = 1;                                                     // Lines
    private int max_lines = 1;                                                 // max Lines
    private int edt_email_confirm_textColor = R.color.black;                   // text Color
    private int edt_email_confirm_textSize = 26;                               // text Size


    //Custom emailConfirm label
    CustomTextView tv_email_confirm = null;
    private boolean tv_email_confirmAdd = true;                                                     //add label email or not
    private int tv_email_confirm_background_color = R.color.white;                                  // Background Color
    private int tv_email_confirm_border_color = R.color.black;                                      // Border Color
    private int tv_email_confirm_border_width = 0;                                                  // Border Width
    private int tv_email_confirm_corner_radius = 0;                                                 // Border Corner radius
    private int tv_email_confirm_textColor = R.color.gray_black;                                    // text Color
    private int tv_email_confirm_textSize = 26;                                                     // text Size
    private int tv_email_confirm_text = R.string.txt_password_email_confirm;                        // text

    //Custom btn_next Submit button
    private CustomSubmitButton btn_next = null;
    private boolean btn_nextAdd = true;                                                             //add label password or not
    private int btn_next_background_color = R.color.button_complete_point_get_background;           // Background Color
    private int btn_next_border_color = R.color.white;                                              // Border Color
    private int btn_next_border_width = 0;                                                          // Border Width
    private int btn_next_corner_radius = 10;                                                        // Border Corner radius
    private int btn_next_textColor = R.color.white;                                                 // text Color
    private int btn_next_textSize = 25;                                                             // text Size
    private int btn_next_text = R.string.btn_password_next;                                         // text


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        headerView = (CustomHeaderView) findViewById(R.id.rlt_header);
        txt_intro = (CustomTextView) findViewById(R.id.txt_intro);
        edt_email = (EmailEditTextView) findViewById(R.id.edt_email);
        tv_email = (CustomTextView) findViewById(R.id.tv_email);
        edt_email_confirm = (EmailEditTextView) findViewById(R.id.edt_email_confirm);
        tv_email_confirm = (CustomTextView) findViewById(R.id.tv_email_confirm);
        btn_next = (CustomSubmitButton) findViewById(R.id.btn_next);
        headerView.setHeaderItemClickListener(this);
        CorrectSizeUtil.getInstance(this).correctSize(findViewById(R.id.rlt_root));
        setUpDefaultTemplate();
    }

    private void setUpDefaultTemplate() {
        //setUpTopBar
        setHeaderHeight(hdrHt);
        setHeaderVisibility(hdrAdd);
        setHeaderText(this.getResources().getString(hdrTxt));
        setHeaderTextColor(hdrTxtCol);
        setHeaderBackgroundColor(hdrBkgrdCol);
        setDropShadow(isDropShadow);

        //Setup Custom txt_intro label
        setIntroLabelVisibility(txt_introAdd);
        txt_intro.setBorderRadius(this.getResources().getColor(txt_intro_background_color),txt_intro_corner_radius,this.getResources().getColor(txt_intro_border_color),txt_intro_border_width);
        txt_intro.setTextProperties(this.getResources().getColor(txt_intro_textColor), txt_intro_textSize);
        txt_intro.resizeTextField(this);
        txt_intro.setText(this.getResources().getString(txt_intro_text));

        //setUp email edittext
        setedtEmailVisibility(edt_emailAdd);
        enableedtEmailHint(edt_emailHintAdd);
        edt_email.setCursor_color(this.getResources().getColor(edt_emailCursorColor));
        edt_email.setBackgroundColor(this.getResources().getColor(edt_email_background_color));
        edt_email.setBorderColor(this.getResources().getColor(edt_email_border_color));
        edt_email.setBorderWidth(edt_email_border_width);
        edt_email.setTextProperties(this.getResources().getColor(edt_email_textColor), edt_email_textSize);
        edt_email.setBorderRadius(edt_email_corner_radius, this.getResources().getColor(edt_email_border_color), edt_email_border_width);
        edt_email.setLines(edt_email_lines);
        edt_email.setMaxLines(edt_email_max_lines);
        edt_email.resizeTextField(this);

        //Setup Custom email label
        setEmailLabelVisibility(tv_emailAdd);
        tv_email.setBorderRadius(this.getResources().getColor(tv_email_background_color),tv_email_corner_radius,this.getResources().getColor(tv_email_border_color),tv_email_border_width);
        tv_email.setTextProperties(this.getResources().getColor(tv_email_textColor), tv_email_textSize);
        tv_email.resizeTextField(this);
        tv_email.setText(this.getResources().getString(tv_email_text));


        //setUp emailConfirm edittext
        setedtEmailConfirmVisibility(edt_email_confirmAdd);
        enableedtEmailHint(edt_email_confirmHintAdd);
        edt_email_confirm.setCursor_color(this.getResources().getColor(edt_email_confirmCursorColor));
        edt_email_confirm.setBackgroundColor(this.getResources().getColor(edt_email_confirm_background_color));
        edt_email_confirm.setBorderColor(this.getResources().getColor(edt_email_confirm_border_color));
        edt_email_confirm.setBorderWidth(edt_email_confirm_border_width);
        edt_email_confirm.setTextProperties(this.getResources().getColor(edt_email_confirm_textColor), edt_email_confirm_textSize);
        edt_email_confirm.setBorderRadius(edt_email_confirm_corner_radius, this.getResources().getColor(edt_email_confirm_border_color), edt_email_confirm_border_width);
        edt_email_confirm.setLines(lines);
        edt_email_confirm.setMaxLines(max_lines);
        edt_email_confirm.resizeTextField(this);

        //Setup Custom emailConfirm label
        setEmailConfirmLabelVisibility(tv_email_confirmAdd);
        tv_email_confirm.setBorderRadius(this.getResources().getColor(tv_email_confirm_background_color),tv_email_confirm_corner_radius,this.getResources().getColor(tv_email_confirm_border_color),tv_email_confirm_border_width);
        tv_email_confirm.setTextProperties(this.getResources().getColor(tv_email_confirm_textColor), tv_email_confirm_textSize);
        tv_email_confirm.resizeTextField(this);
        tv_email_confirm.setText(this.getResources().getString(tv_email_confirm_text));

        //Set up custom login button
        setBtnNextVisibility(btn_nextAdd);
        btn_next.setBorderRadius(this.getResources().getColor(btn_next_background_color),btn_next_corner_radius,this.getResources().getColor(btn_next_border_color),btn_next_border_width);
        btn_next.setText(this.getResources().getString(btn_next_text));
        btn_next.setTextColor(this.getResources().getColor(btn_next_textColor));
        btn_next.setTextSize(btn_next_textSize);
        btn_next.setTag(String.valueOf(btn_next_textSize));
    }
    //submit button functions
    private void setBtnNextVisibility(boolean visible) {
        if(visible)
            btn_next.setVisibility(View.VISIBLE);
        else
            btn_next.setVisibility(View.GONE);
    }
    //emailConfirm label functions
    private void setEmailConfirmLabelVisibility(boolean visible) {
        if(visible)
            tv_email_confirm.setVisibility(View.VISIBLE);
        else
            tv_email_confirm.setVisibility(View.GONE);
    }
    //emailConfirm edittext functions
    private void setedtEmailConfirmVisibility(boolean visible) {
        if(visible)
            edt_email_confirm.setVisibility(View.VISIBLE);
        else
            edt_email_confirm.setVisibility(View.GONE);
    }
    //intro label functions
    private void setIntroLabelVisibility(boolean visible) {
        if(visible)
            txt_intro.setVisibility(View.VISIBLE);
        else
            txt_intro.setVisibility(View.GONE);
    }
    //email label functions
    private void setEmailLabelVisibility(boolean visible) {
        if (visible)
            tv_email.setVisibility(View.VISIBLE);
        else
            tv_email.setVisibility(View.GONE);
    }
    //email edittext functions
    private void enableedtEmailHint(boolean visible) {
        if (visible)
            edt_email.setHint(edt_emailHint, this.getResources().getColor(edt_emailHintColor));
        else
            edt_email.setHint("", this.getResources().getColor(edt_emailHintColor));
    }
    private void setedtEmailVisibility(boolean visible) {
        if (visible)
            edt_email.setVisibility(View.VISIBLE);
        else
            edt_email.setVisibility(View.GONE);
    }
    //header methods
    private void setHeaderHeight(int hdrHt) {
        headerView.getLayoutParams().height = hdrHt;
        CorrectSizeUtil.getInstance(this).correctSizeByLayout(headerView);
    }
    private void setDropShadow(boolean isDropShadow) {
        headerView.setDropShadow(isDropShadow);
    }
    private void setHeaderBackgroundColor(int hdrBkgrdCol) {
        headerView.setBackgrndColor(hdrBkgrdCol);
    }
    private void setHeaderTextColor(int hdrTxtCol) {
        //for test purpose
        hdrTxtCol = this.getResources().getColor(R.color.black);
        headerView.setTextColor(hdrTxtCol);
    }
    private void setHeaderText(String hdrTxt) {
        if (hdrTxt != null) {
            headerView.setText(hdrTxt);
        }
    }
    private void setHeaderVisibility(boolean visible) {
        if (visible)
            headerView.setVisibility(View.VISIBLE);
        else
            headerView.setVisibility(View.GONE);
    }

    @Override
    public void onLeftItemClick() {
        finish();
    }

    @Override
    public void onRightItemClick() {

    }

    @Override
    public void onTitleClick() {

    }
}
