package ocuiparts.com.library.Activities;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.androidannotations.annotations.EActivity;

import ocuiparts.com.library.Base.BaseActivity;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.customButtons.CustomSubmitButton;
import ocuiparts.com.library.customEditText.EmailEditTextView;
import ocuiparts.com.library.customView.CustomHeaderView;
import ocuiparts.com.library.customView.CustomTextView;

/**
 * Created by mdmunirhossain on 4/20/18.
 */

@EActivity
public class LoginMikataIDActivity extends BaseActivity {
    // Header
    private CustomHeaderView headerView = null;
    private boolean hdrAdd = true;            // Add header or not
    private ImageView hdrImg;                 // Header image
    private int hdrTxt = R.string.txt_sign_up;            // Header text
    private int hdrTxtCol = R.color.black;    // Header text color
    private int hdrBkgrdCol = R.color.white;  // Header background color
    private boolean isDropShadow = true;      // Add DropShadow or not
    private int hdrHt = 120;                  // Header height


    //Custom login intro label
    CustomTextView login_intro = null;
    private boolean login_introAdd = true;                                                //add label password or not
    private int login_intro_background_color = R.color.grayTextIntro;                     // Background Color
    private int login_intro_border_color = R.color.white;                                 // Border Color
    private int login_intro_border_width = 0;                                             // Border Width
    private int login_intro_corner_radius = 0;                                            // Border Corner radius
    private int login_intro_textColor = R.color.gray_black;                               // text Color
    private int login_intro_textSize = 32;                                                // text Size
    private int login_intro_text = R.string.txt_login_mikata_intro;      // text


    //Custom EmailEditTextView
    EmailEditTextView edt_email = null;
    private boolean edt_emailAdd = true;                               // Add emailEdittext or not
    private boolean edt_emailHintAdd = false;                          // Add hint or not
    private String edt_emailHint = "hello hint";                       // Hint Text
    private int edt_emailHintColor = R.color.hint_color;               // Hint color
    private int edt_emailCursorColor = R.color.colorAccent;            // cursor color
    private int edt_email_background_color = R.color.white;            // Background Color
    private int edt_email_border_color = R.color.white;                // Border Color
    private int edt_email_border_width = 0;                            // Border Width
    private int edt_email_corner_radius = 0;                           // Border Corner radius
    private int lines = 1;                                             // Lines
    private int max_lines = 1;                                         // max Lines
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
    private int tv_email_text = R.string.login_email;                        // text


    //Custom password label
    CustomTextView tv_password = null;
    private boolean tv_passwordAdd = true;                               //add label password or not
    private int tv_password_background_color = R.color.white;            // Background Color
    private int tv_password_border_color = R.color.black;                // Border Color
    private int tv_password_border_width = 0;                            // Border Width
    private int tv_password_corner_radius = 0;                           // Border Corner radius
    private int tv_password_textColor = R.color.gray_black;              // text Color
    private int tv_password_textSize = 26;                               // text Size
    private int tv_password_text = R.string.login_password;                           // text


    //Custom login Submit button
    private CustomSubmitButton btnlogIn = null;
    private boolean btnlogInAdd = true;                              //add label password or not
    private int btnlogIn_background_color = R.color.black;           // Background Color
    private int btnlogIn_border_color = R.color.white;               // Border Color
    private int btnlogIn_border_width = 0;                           // Border Width
    private int btnlogIn_corner_radius = 10;                         // Border Corner radius
    private int btnlogIn_textColor = R.color.white;                  // text Color
    private int btnlogIn_textSize = 25;                              // text Size
    private int btnlogIn_text = R.string.btn_sign_in_mikata;                  // text


    //Custom password label
    CustomTextView txt_back = null;
    private boolean txt_backAdd = true;                               //add label password or not
    private int txt_back_background_color = R.color.homeBackground;   // Background Color
    private int txt_back_border_color = R.color.white;                // Border Color
    private int txt_back_border_width = 0;                            // Border Width
    private int txt_back_corner_radius = 0;                           // Border Corner radius
    private int txt_back_textColor = R.color.gray_black;              // text Color
    private int txt_back_textSize = 33;                               // text Size
    private int txt_back_text = R.string.login_forgot_password_intro;             // text



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mikata_id);
        headerView = (CustomHeaderView) findViewById(R.id.header);
        login_intro = (CustomTextView) findViewById(R.id.login_intro);
        edt_email = (EmailEditTextView) findViewById(R.id.edt_email);
        tv_email = (CustomTextView) findViewById(R.id.tv_email);
        tv_password = (CustomTextView) findViewById(R.id.tv_password);
        btnlogIn = (CustomSubmitButton) findViewById(R.id.btn_login);
        txt_back = (CustomTextView) findViewById(R.id.txt_back);

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


        //Setup Custom login_intro label
        setLoginIntroLabelVisibility(login_introAdd);
        login_intro.setBorderRadius(this.getResources().getColor(login_intro_background_color),login_intro_corner_radius,this.getResources().getColor(login_intro_border_color),login_intro_border_width);
        login_intro.setTextProperties(this.getResources().getColor(login_intro_textColor), login_intro_textSize);
        login_intro.resizeTextField(this);
        login_intro.setText(this.getResources().getString(login_intro_text));

        //setUp email edittext
        setedtEmailVisibility(edt_emailAdd);
        enableedtEmailHint(edt_emailHintAdd);
        edt_email.setCursor_color(this.getResources().getColor(edt_emailCursorColor));
        edt_email.setBackgroundColor(this.getResources().getColor(edt_email_background_color));
        edt_email.setBorderColor(this.getResources().getColor(edt_email_border_color));
        edt_email.setBorderWidth(edt_email_border_width);
        edt_email.setTextProperties(this.getResources().getColor(edt_email_textColor), edt_email_textSize);
        edt_email.setBorderRadius(edt_email_corner_radius, this.getResources().getColor(edt_email_border_color), edt_email_border_width);
        edt_email.setLines(lines);
        edt_email.setMaxLines(max_lines);
        edt_email.resizeTextField(this);

        //Setup Custom email label
        setEmailLabelVisibility(tv_emailAdd);
        tv_email.setBorderRadius(this.getResources().getColor(tv_email_background_color),tv_email_corner_radius,this.getResources().getColor(tv_email_border_color),tv_email_border_width);
        tv_email.setTextProperties(this.getResources().getColor(tv_email_textColor), tv_email_textSize);
        tv_email.resizeTextField(this);
        tv_email.setText(this.getResources().getString(tv_email_text));


        //Setup Custom password label
        setPasswordLabelVisibility(tv_passwordAdd);
        tv_password.setBorderRadius(this.getResources().getColor(tv_password_background_color),tv_password_corner_radius,this.getResources().getColor(tv_password_border_color),tv_password_border_width);
        tv_password.setTextProperties(this.getResources().getColor(tv_password_textColor), tv_password_textSize);
        tv_password.resizeTextField(this);
        tv_password.setText(this.getResources().getString(tv_password_text));

        //Set up custom login button
        setbtnlogInVisibility(btnlogInAdd);
        btnlogIn.setBorderRadius(this.getResources().getColor(btnlogIn_background_color),btnlogIn_corner_radius,this.getResources().getColor(btnlogIn_border_color),btnlogIn_border_width);
        btnlogIn.setText(this.getResources().getString(btnlogIn_text));
        btnlogIn.setTextColor(this.getResources().getColor(btnlogIn_textColor));
        btnlogIn.setTextSize(btnlogIn_textSize);
        btnlogIn.setTag(String.valueOf(btnlogIn_textSize));

        //Setup Custom password label
        setBackLabelVisibility(txt_backAdd);
        txt_back.setBorderRadius(this.getResources().getColor(txt_back_background_color),txt_back_corner_radius,this.getResources().getColor(txt_back_border_color),txt_back_border_width);
        txt_back.setTextProperties(this.getResources().getColor(txt_back_textColor), txt_back_textSize);
        txt_back.resizeTextField(this);
        txt_back.setText(this.getResources().getString(txt_back_text));

    }
    private void setLoginIntroLabelVisibility(boolean visible) {
        if (visible)
            login_intro.setVisibility(View.VISIBLE);
        else
            login_intro.setVisibility(View.GONE);
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

    private void setEmailLabelVisibility(boolean visible) {
        if (visible)
            tv_email.setVisibility(View.VISIBLE);
        else
            tv_email.setVisibility(View.GONE);
    }

    private void setPasswordLabelVisibility(boolean visible) {
        if (visible)
            tv_password.setVisibility(View.VISIBLE);
        else
            tv_password.setVisibility(View.GONE);
    }

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

    private void setbtnlogInVisibility(boolean visible) {
        if (visible)
            btnlogIn.setVisibility(View.VISIBLE);
        else
            btnlogIn.setVisibility(View.GONE);
    }

    private void setBackLabelVisibility(boolean visible) {
        if (visible)
            txt_back.setVisibility(View.VISIBLE);
        else
            txt_back.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        afterClickBack();
    }
    public void back_pressed(View view) {
        afterClickBack();
    }

    private void afterClickBack(){
        finish();
        overridePendingTransition(R.anim.stand_by, R.anim.left_to_right);
    }
}


