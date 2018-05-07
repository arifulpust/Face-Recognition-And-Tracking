package ocuiparts.com.library.Activities;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import ocuiparts.com.library.Base.BaseActivity;
import ocuiparts.com.library.Interface.HeaderItemClickListener;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.Utils.Utils;
import ocuiparts.com.library.customButtons.CustomSubmitButton;
import ocuiparts.com.library.customEditText.EmailEditTextView;
import ocuiparts.com.library.customEditText.PasswordEditTextView;
import ocuiparts.com.library.customView.CustomHeaderView;
import ocuiparts.com.library.customView.CustomImageView;
import ocuiparts.com.library.customView.CustomTextView;


@EActivity
public class LoginActivity extends BaseActivity {
    // Header
    private CustomHeaderView headerView = null;
    private boolean hdrAdd = true;            // Add header or not
    private ImageView hdrImg;                 // Header image
    private int hdrTxt = R.string.btn_login;            // Header text
    private int hdrTxtCol = R.color.black;    // Header text color
    private int hdrBkgrdCol = R.color.white;  // Header background color
    private boolean isDropShadow = true;      // Add DropShadow or not
    private int hdrHt = 120;                  // Header height

    //Custom ImageView
    CustomImageView title_image = null;
    private boolean titleImgAdd = true;                                 // Add titleImage or not
    private int titleImage_background_color = R.color.homeBackground;   // Background Color
    private int titleImage_border_color = R.color.white;                // Border Color
    private int titleImage_border_width = 100;                          // Border Width
    private int titleImage_corner_radius = 0;                           // Border Corner radius
    private int title_image_src = R.drawable.default_header;            // Image Source
    private boolean title_text_visible = true;                          // Add text title or not
    private int title_text_color = R.color.black;                       // title text color
    private String title_text = "ログイン";                               // title text
    private int title_text_fontSize = 32;                               // title text font Size

    //Custom EmailEditTextView
    private boolean edtAdd = true;                                      //Relative layout for full email edittext field show or not
    RelativeLayout edt_email_field=null;                                 //Relative layout for full email edittext field
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



    //Custom PasswordEditTextView
    private boolean edtPasswordAdd = true;                                //Relative layout for full password edittext field show or not
    RelativeLayout edt_password_field=null;                               //Relative layout for full password edittext field
    PasswordEditTextView edt_password = null;
    private boolean edt_passwordAdd = true;                               // Add emailEdittext or not
    private boolean edt_passwordHintAdd = false;                          // Add hint or not
    private String edt_passwordHint = "hello hint";                       // Hint Text
    private int edt_passwordHintColor = R.color.hint_color;               // Hint color
    private int edt_passwordCursorColor = R.color.colorAccent;            // cursor color
    private int edt_password_background_color = R.color.white;            // Background Color
    private int edt_password_border_color = R.color.white;                // Border Color
    private int edt_password_border_width = 0;                            // Border Width
    private int edt_password_corner_radius = 0;                           // Border Corner radius
    private int pass_lines = 1;                                           // Lines
    private int pass_max_lines = 1;                                       // max Lines
    private int edt_password_textColor = R.color.black;                   // text Color
    private int edt_password_textSize = 26;
    private int edt_password_icon_visibility_on = R.drawable.ic_btn_password_on;
    private int edt_password_icon_visibility_off = R.drawable.ic_btn_password_off;



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


    //Custom password label
    CustomTextView txt_forgot_password = null;
    private boolean txt_forgot_passwordAdd = true;                               //add label password or not
    private int txt_forgot_password_background_color = R.color.homeBackground;   // Background Color
    private int txt_forgot_password_border_color = R.color.white;                // Border Color
    private int txt_forgot_password_border_width = 0;                            // Border Width
    private int txt_forgot_password_corner_radius = 0;                           // Border Corner radius
    private int txt_forgot_password_textColor = R.color.gray_black;              // text Color
    private int txt_forgot_password_textSize = 34;                               // text Size
    private int txt_forgot_password_text = R.string.login_forgot_password_intro;             // text

    //middle borderview

    private View middle_border_view=null;
    private boolean middleBorderAdd = true;

    //Custom signup intro label
    CustomTextView sign_up_intro = null;
    private boolean sign_up_introAdd = true;                               //add label password or not
    private int sign_up_intro_background_color = R.color.homeBackground;   // Background Color
    private int sign_up_intro_border_color = R.color.white;                // Border Color
    private int sign_up_intro_border_width = 0;                            // Border Width
    private int sign_up_intro_corner_radius = 0;                           // Border Corner radius
    private int sign_up_intro_textColor = R.color.gray_black;              // text Color
    private int sign_up_intro_textSize = 33;                               // text Size
    private int sign_up_intro_text = R.string.login_sign_up_intro;           // text


    //Custom signup intro label
    CustomTextView txt_login_term_service = null;
    private boolean txt_login_term_serviceAdd = true;                                       //add label password or not
    private int txt_login_term_service_background_color = R.color.homeBackground;           // Background Color
    private int txt_login_term_service_border_color = R.color.white;                        // Border Color
    private int txt_login_term_service_border_width = 0;                                    // Border Width
    private int txt_login_term_service_corner_radius = 0;                                   // Border Corner radius
    private int txt_login_term_service_textColor = R.color.gray_black;                      // text Color
    private int txt_login_term_service_textSize = 25;                                       // text Size
    private int txt_login_term_service_text = R.string.txt_login_term_service;     // text

    //Custom login Submit button
    private CustomSubmitButton btnlogIn = null;
    private boolean btnlogInAdd = true;                              //add label password or not
    private int btnlogIn_background_color = R.color.black;           // Background Color
    private int btnlogIn_border_color = R.color.white;               // Border Color
    private int btnlogIn_border_width = 0;                           // Border Width
    private int btnlogIn_corner_radius = 10;                         // Border Corner radius
    private int btnlogIn_textColor = R.color.white;                  // text Color
    private int btnlogIn_textSize = 25;                              // text Size
    private int btnlogIn_text = R.string.btn_login;                            // text

    //Custom Mikata id login Submit button
    private CustomSubmitButton btnMikatalogIn = null;
    private boolean btnMikatalogInAdd = true;                              //add label password or not
    private int btnMikatalogIn_background_color = R.color.black;           // Background Color
    private int btnMikatalogIn_border_color = R.color.white;               // Border Color
    private int btnMikatalogIn_border_width = 0;                           // Border Width
    private int btnMikatalogIn_corner_radius = 10;                         // Border Corner radius
    private int btnMikatalogIn_textColor = R.color.white;                  // text Color
    private int btnMikatalogIn_textSize = 25;                              // text Size
    private int btnMikatalogIn_text = R.string.btn_login_mikata_id;                  // text



    //Custom sign up Submit button
    private CustomSubmitButton btnSignUp = null;
    private boolean btnSignUpAdd = true;                                                             //add label password or not
    private int btnSignUp_background_color = R.color.button_complete_point_get_background;           // Background Color
    private int btnSignUp_border_color = R.color.white;                                              // Border Color
    private int btnSignUp_border_width = 0;                                                          // Border Width
    private int btnSignUp_corner_radius = 10;                                                        // Border Corner radius
    private int btnSignUp_textColor = R.color.white;                                                 // text Color
    private int btnSignUp_textSize = 25;                                                             // text Size
    private int btnSignUp_text = R.string.btn_sign_up;                                                          // text



    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        headerView = (CustomHeaderView) findViewById(R.id.rlt_header);
        title_image = (CustomImageView) findViewById(R.id.title_image);
        edt_email = (EmailEditTextView) findViewById(R.id.edt_email);
        edt_email_field=(RelativeLayout) findViewById(R.id.edittext_field);
        edt_password_field=(RelativeLayout) findViewById(R.id.password_edittext_field);
        edt_password = (PasswordEditTextView) findViewById(R.id.edt_password);
        tv_email = (CustomTextView) findViewById(R.id.tv_email);
        tv_password = (CustomTextView) findViewById(R.id.tv_password);
        txt_forgot_password = (CustomTextView) findViewById(R.id.txt_forgot_password);
        middle_border_view=(View)  findViewById(R.id.middle_border);
        sign_up_intro = (CustomTextView) findViewById(R.id.sign_up_intro);
        txt_login_term_service = (CustomTextView) findViewById(R.id.txt_login_term_service);


        btnSignUp = (CustomSubmitButton) findViewById(R.id.btn_sign_up);
        btnlogIn = (CustomSubmitButton) findViewById(R.id.btn_login);
        btnMikatalogIn = (CustomSubmitButton) findViewById(R.id.btn_login_mikata_id);

        headerView.setHeaderItemClickListener(new HeaderItemClickListener() {
            @Override
            public void onLeftItemClick() {
                Toast.makeText(LoginActivity.this, "left Clicked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRightItemClick() {
                Toast.makeText(LoginActivity.this, "right Clicked", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onTitleClick() {
                Toast.makeText(LoginActivity.this, "title Clicked", Toast.LENGTH_LONG).show();

            }
        });
        txt_forgot_password.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginActivity.this, PasswordActivity.class);
                startActivity(i);

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
        btnlogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
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

        //setUp title image
        settitleImageVisibility(titleImgAdd);
        title_image.setImageBackgroundColor(this.getResources().getColor(titleImage_background_color));
        title_image.setBorderRadius(titleImage_corner_radius, this.getResources().getColor(titleImage_border_color), titleImage_border_width);
        title_image.setImage(BitmapFactory.decodeResource(getResources(), title_image_src));
        title_image.settitleTextVisible(title_text_visible);
        title_image.setTextColor(this.getResources().getColor(title_text_color));
        title_image.setText(title_text);
        title_image.setTextSize(title_text_fontSize);
        title_image.setTopMarginText(15);
        title_image.resizeTextField(this);


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



        //setUp password edittext
        setedtPasswordVisibility(edt_passwordAdd);
        enableedtPasswordHint(edt_passwordHintAdd);
        edt_password.setCursor_color(this.getResources().getColor(edt_passwordCursorColor));
        edt_password.setBackgroundColor(this.getResources().getColor(edt_password_background_color));
        edt_password.setBorderColor(this.getResources().getColor(edt_password_border_color));
        edt_password.setBorderWidth(edt_password_border_width);
        edt_password.setTextProperties(this.getResources().getColor(edt_password_textColor), edt_password_textSize);
        edt_password.setBorderRadius(edt_password_corner_radius, this.getResources().getColor(edt_password_border_color), edt_password_border_width);
        edt_password.setLines(lines);
        edt_password.setMaxLines(max_lines);
        edt_password.resizeTextField(this);
        edt_password.setPasswordVisibiltyIconOn(getResources().getDrawable(R.drawable.ic_btn_password_on));
        edt_password.setPasswordVisibiltyIconOff(getResources().getDrawable(R.drawable.ic_btn_password_off));




        //Setup Custom email label
        setEmailFieldVisibility(edtAdd);
        setEmailLabelVisibility(tv_emailAdd);
        tv_email.setBorderRadius(this.getResources().getColor(tv_email_background_color),tv_email_corner_radius,this.getResources().getColor(tv_email_border_color),tv_email_border_width);
        tv_email.setTextProperties(this.getResources().getColor(tv_email_textColor), tv_email_textSize);
        tv_email.resizeTextField(this);
        tv_email.setText(this.getResources().getString(tv_email_text));


        //Setup Custom password label
        setPasswordFieldVisibility(edtPasswordAdd);
        setPasswordLabelVisibility(tv_passwordAdd);
        tv_password.setBorderRadius(this.getResources().getColor(tv_password_background_color),tv_password_corner_radius,this.getResources().getColor(tv_password_border_color),tv_password_border_width);
        tv_password.setTextProperties(this.getResources().getColor(tv_password_textColor), tv_password_textSize);
        tv_password.resizeTextField(this);
        tv_password.setText(this.getResources().getString(tv_password_text));

        //Setup Custom password label
        setForgotPasswordLabelVisibility(txt_forgot_passwordAdd);
        txt_forgot_password.setBorderRadius(this.getResources().getColor(txt_forgot_password_background_color),txt_forgot_password_corner_radius,this.getResources().getColor(txt_forgot_password_border_color),txt_forgot_password_border_width);
        txt_forgot_password.setTextProperties(this.getResources().getColor(txt_forgot_password_textColor), txt_forgot_password_textSize);
        txt_forgot_password.resizeTextField(this);
        txt_forgot_password.setText(this.getResources().getString(txt_forgot_password_text));



        //set middle border visibility
        setMiddleBorderVisibility(middleBorderAdd);



        //Setup Custom sign_up_intro label
        setSignupIntroLabelVisibility(sign_up_introAdd);
        sign_up_intro.setBorderRadius(this.getResources().getColor(sign_up_intro_background_color),sign_up_intro_corner_radius,this.getResources().getColor(sign_up_intro_border_color),sign_up_intro_border_width);
        sign_up_intro.setTextProperties(this.getResources().getColor(sign_up_intro_textColor), sign_up_intro_textSize);
        sign_up_intro.resizeTextField(this);
        sign_up_intro.setText(this.getResources().getString(sign_up_intro_text));


        //Setup Custom txt_login_term_service label
        setTxtTermServiceLabelVisibility(txt_login_term_serviceAdd);
        txt_login_term_service.setBorderRadius(this.getResources().getColor(txt_login_term_service_background_color),txt_login_term_service_corner_radius,this.getResources().getColor(txt_login_term_service_border_color),txt_login_term_service_border_width);
        txt_login_term_service.setTextProperties(this.getResources().getColor(txt_login_term_service_textColor), txt_login_term_service_textSize);
        txt_login_term_service.resizeTextField(this);
        txt_login_term_service.setText(this.getResources().getString(txt_login_term_service_text));


        //Set up custom login button
        setbtnlogInVisibility(btnlogInAdd);
        btnlogIn.setBorderRadius(this.getResources().getColor(btnlogIn_background_color),btnlogIn_corner_radius,this.getResources().getColor(btnlogIn_border_color),btnlogIn_border_width);
        btnlogIn.setText(this.getResources().getString(btnlogIn_text));
        btnlogIn.setTextColor(this.getResources().getColor(btnlogIn_textColor));
        btnlogIn.setTextSize(btnlogIn_textSize);
        btnlogIn.setTag(String.valueOf(btnlogIn_textSize));


        //Set up custom login Mikata id button
        setbtnMikatalogInVisibility(btnMikatalogInAdd);
        btnMikatalogIn.setBorderRadius(this.getResources().getColor(btnMikatalogIn_background_color),btnMikatalogIn_corner_radius,this.getResources().getColor(btnMikatalogIn_border_color),btnMikatalogIn_border_width);
        btnMikatalogIn.setText(this.getResources().getString(btnMikatalogIn_text));
        btnMikatalogIn.setTextColor(this.getResources().getColor(btnMikatalogIn_textColor));
        btnMikatalogIn.setTextSize(btnMikatalogIn_textSize);
        btnMikatalogIn.setTag(String.valueOf(btnMikatalogIn_textSize));


        //Set up custom sighn Up button
        setbtnSignUpVisibility(btnSignUpAdd);
        btnSignUp.setBorderRadius(this.getResources().getColor(btnSignUp_background_color),btnSignUp_corner_radius,this.getResources().getColor(btnSignUp_border_color),btnSignUp_border_width);
        btnSignUp.setText(this.getResources().getString(btnSignUp_text));
        btnSignUp.setTextColor(this.getResources().getColor(btnSignUp_textColor));
        btnSignUp.setTextSize(btnSignUp_textSize);
        btnSignUp.setTag(String.valueOf(btnSignUp_textSize));

    }

    private void setbtnMikatalogInVisibility(boolean visible) {
        if (visible)
            btnMikatalogIn.setVisibility(View.VISIBLE);
        else
            btnMikatalogIn.setVisibility(View.GONE);
    }

    private void setbtnSignUpVisibility(boolean visible) {
        if (visible)
            btnSignUp.setVisibility(View.VISIBLE);
        else
            btnSignUp.setVisibility(View.GONE);
    }

    private void setbtnlogInVisibility(boolean visible) {
        if (visible)
            btnlogIn.setVisibility(View.VISIBLE);
        else
            btnlogIn.setVisibility(View.GONE);
    }

    private void setTxtTermServiceLabelVisibility(boolean visible) {
        if (visible)
            txt_login_term_service.setVisibility(View.VISIBLE);
        else
            txt_login_term_service.setVisibility(View.GONE);
    }



    private void setMiddleBorderVisibility(boolean visible) {
        if (visible)
            middle_border_view.setVisibility(View.VISIBLE);
        else
            middle_border_view.setVisibility(View.GONE);
    }


    private void setSignupIntroLabelVisibility(boolean visible) {
        if (visible)
            sign_up_intro.setVisibility(View.VISIBLE);
        else
            sign_up_intro.setVisibility(View.GONE);
    }

    private void setForgotPasswordLabelVisibility(boolean visible) {
        if (visible)
            txt_forgot_password.setVisibility(View.VISIBLE);
        else
            txt_forgot_password.setVisibility(View.GONE);
    }


    private void setEmailLabelVisibility(boolean visible) {
        if (visible)
            tv_email.setVisibility(View.VISIBLE);
        else
            tv_email.setVisibility(View.GONE);
    }


    private void setEmailFieldVisibility(boolean visible) {
        if (visible)
            edt_email_field.setVisibility(View.VISIBLE);
        else
            edt_email_field.setVisibility(View.GONE);
    }


    private void setPasswordLabelVisibility(boolean visible) {
        if (visible)
            tv_password.setVisibility(View.VISIBLE);
        else
            tv_password.setVisibility(View.GONE);
    }


    private void setPasswordFieldVisibility(boolean visible) {
        if (visible)
            edt_password_field.setVisibility(View.VISIBLE);
        else
            edt_password_field.setVisibility(View.GONE);
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

    private void setedtPasswordVisibility(boolean visible) {
        if (visible)
            edt_password.setVisibility(View.VISIBLE);
        else
            edt_password.setVisibility(View.GONE);
    }

    private void enableedtPasswordHint(boolean visible) {
        if (visible)
            edt_password.setHintPassword(edt_passwordHint, this.getResources().getColor(edt_passwordHintColor));
        else
            edt_password.setHintPassword("", this.getResources().getColor(edt_passwordHintColor));
    }



    private void settitleImageVisibility(boolean visible) {
        if (visible)
            title_image.setVisibility(View.VISIBLE);
        else
            title_image.setVisibility(View.GONE);
    }

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



    public void clickLoginMikataID(View view) {
        hideKB();
        Intent i = new Intent(this, LoginMikataIDActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.right_to_left, R.anim.stand_by);
    }


    public void hideKB() {
        View v = findViewById(R.id.rlt_root);
        if (v != null) {
            Utils.hideKeyboard(this, v);
        } // no else
    }

}
