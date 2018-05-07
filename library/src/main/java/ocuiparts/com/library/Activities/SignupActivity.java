package ocuiparts.com.library.Activities;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.androidannotations.annotations.EActivity;
import ocuiparts.com.library.Base.BaseActivity;
import ocuiparts.com.library.Interface.HeaderItemClickListener;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.customButtons.CustomSubmitButton;
import ocuiparts.com.library.customEditText.EmailEditTextView;
import ocuiparts.com.library.customEditText.PasswordEditTextView;
import ocuiparts.com.library.customView.CustomHeaderView;


@EActivity
public class SignupActivity extends BaseActivity {


    // Header
    private CustomHeaderView headerView = null;
    private boolean hdrAdd = true;            // Add header or not
    private ImageView hdrImg;                 // Header image
    private int hdrTxt = R.string.btn_login;  // Header text
    private int hdrTxtCol = R.color.black;    // Header text color
    private int hdrBkgrdCol = R.color.white;  // Header background color
    private boolean isDropShadow = true;      // Add DropShadow or not
    private int hdrHt = 120;                  // Header height


    //Custom EmailEditTextView

    private boolean edtFieldAdd = true;
    private boolean edtAdd = true;      //Relative layout for full email edittext field show or not
    RelativeLayout edt_email_field = null;                                 //Relative layout for full email edittext field
    EmailEditTextView edt_register_code = null;
    private boolean registerAdd = true;                               // Add emailEdittext or not
    private boolean edt_emailHintAdd = true;                          // Add hint or not
    private String edt_emailHint = "賃貸契約時発行パスワード";                       // Hint Text
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


    //edittext  name
    //Custom EmailEditTextView

    private boolean edtNameFieldAdd = true;
    private boolean edtNameAdd = true;      //Relative layout for full email edittext field show or not
    RelativeLayout edt_name_field = null;                                 //Relative layout for full email edittext field
    EmailEditTextView edt_name = null;
   // private boolean nameAdd = true;                               // Add emailEdittext or not
    private boolean edt_nameHintAdd = true;                          // Add hint or not
    private String edt_nameHint ="氏名";                       // Hint Text
    private int edt_nameHintColor = R.color.hint_color;               // Hint color
    private int edt_nameCursorColor = R.color.colorAccent;            // cursor color
    private int edt_name_background_color = R.color.white;            // Background Color
    private int edt_name_border_color = R.color.white;                // Border Color
    private int edt_name_border_width = 0;                            // Border Width
    private int edt_name_corner_radius = 0;                           // Border Corner radius
    private int name_lines = 1;                                             // Lines
    private int name_max_lines = 1;                                         // max Lines
    private int edt_name_textColor = R.color.black;                   // text Color
    private int edt_name_textSize = 26;


    //Custom EmailEditTextView

    private boolean edtUserNameFieldAdd = true;
    private boolean edtUserNameAdd = true;      //Relative layout for full email edittext field show or not
    RelativeLayout edt_user_name_field = null;                                 //Relative layout for full email edittext field
    EmailEditTextView edt_user_name = null;
    // private boolean nameAdd = true;                               // Add emailEdittext or not
    private boolean edt_user_nameHintAdd = true;                          // Add hint or not
    private String edt_user_nameHint ="ユーザー名";                    // Hint Text
    private int edt_user_nameHintColor = R.color.hint_color;               // Hint color
    private int edt_user_nameCursorColor = R.color.colorAccent;            // cursor color
    private int edt_user_name_background_color = R.color.white;            // Background Color
    private int edt_user_name_border_color = R.color.white;                // Border Color
    private int edt_user_name_border_width = 0;                            // Border Width
    private int edt_user_name_corner_radius = 0;                           // Border Corner radius
    private int user_name_lines = 1;                                             // Lines
    private int user_name_max_lines = 1;                                         // max Lines
    private int edt_user_name_textColor = R.color.black;                   // text Color
    private int edt_user_name_textSize = 26;


    //Custom EmailEditTextView

    private boolean edtEmailFieldAdd = true;
    private boolean edtEmailAdd = true;      //Relative layout for full email edittext field show or not
    RelativeLayout edtemail_field = null;                                 //Relative layout for full email edittext field
    EmailEditTextView edtemail = null;
    // private boolean nameAdd = true;                               // Add emailEdittext or not
    private boolean edtemailHintAdd = true;                          // Add hint or not
    private String edtemailHint = "メールアドレス";                           // Hint Text
    private int edtemailHintColor = R.color.hint_color;               // Hint color
    private int edtemailCursorColor = R.color.colorAccent;            // cursor color
    private int email_background_color = R.color.white;            // Background Color
    private int email_border_color = R.color.white;                // Border Color
    private int email_border_width = 0;                            // Border Width
    private int email_corner_radius = 0;                           // Border Corner radius
    private int email_lines = 1;                                             // Lines
    private int email_max_lines = 1;                                         // max Lines
    private int email_textColor = R.color.black;                   // text Color
    private int email_textSize = 26;



    //Custom PasswordEditTextView
    private boolean edtPasswordAdd = true;   //Relative layout for full password edittext field show or not
    RelativeLayout edt_password_field=null; //Relative layout for full password edittext field
    PasswordEditTextView edt_password = null;
    private boolean edt_passwordAdd = true;                               // Add emailEdittext or not
    private boolean edt_passwordHintAdd = true;                          // Add hint or not
    private String edt_passwordHint ="半角英数字8~20文字";                         // Hint Text
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


    //Custom EmailEditTextView phone

    private boolean edtPhoneFieldAdd = true;
    private boolean edtPhoneAdd = true;      //Relative layout for full email edittext field show or not
    RelativeLayout edt_phone_field = null;                                 //Relative layout for full email edittext field
    EmailEditTextView edt_phone = null;
    private boolean edt_phoneHintAdd = true;                          // Add hint or not
    private String edt_phoneHint ="電話番号";                        // Hint Text
    private int edt_phoneHintColor = R.color.hint_color;               // Hint color
    private int edt_phoneCursorColor = R.color.colorAccent;            // cursor color
    private int edt_phone_background_color = R.color.white;            // Background Color
    private int edt_phone_border_color = R.color.white;                // Border Color
    private int edt_phone_border_width = 0;                            // Border Width
    private int edt_phone_corner_radius = 0;                           // Border Corner radius
    private int phone_lines = 1;                                             // Lines
    private int phone_max_lines = 1;                                         // max Lines
    private int edt_phone_textColor = R.color.black;                   // text Color
    private int edt_phone_textSize = 26;


    //Custom EmailEditTextView birthday
    private boolean edtBirthdayAdd = true;                                      //Relative layout for full email edittext field show or not
    RelativeLayout edt_birthday_field=null;                                 //Relative layout for full email edittext field
    EmailEditTextView edt_birthday = null;
    private boolean edt_birthdayAdd = true;                               // Add emailEdittext or not
    private boolean edtbirthdayHintAdd = true;                          // Add hint or not
    private String edt_birthdayHint ="生年月日";                                 // Hint Text
    private int edt_birthdayHintColor = R.color.hint_color;               // Hint color
    private int edt_birthdayCursorColor = R.color.colorAccent;            // cursor color
    private int edt_birthday_background_color = R.color.white;            // Background Color
    private int edt_birthday_border_color = R.color.white;                // Border Color
    private int edt_birthday_border_width = 0;                            // Border Width
    private int edt_birthday_corner_radius = 0;                           // Border Corner radius
    private int birthday_lines = 1;                                             // Lines
    private int birthday_max_lines = 1;                                         // max Lines
    private int edt_birthday_textColor = R.color.black;                   // text Color
    private int edt_birthday_textSize = 26;                               // text Size



    //Custom signup Submit button
    private CustomSubmitButton btnSignUp = null;
    private boolean btnsignUpAdd = true;                              //add label password or not
    private int btnsignUp_background_color = R.color.colorAccentNew;           // Background Color
    private int btnsignUp_border_color = R.color.white;               // Border Color
    private int btnsignUp_border_width = 0;                           // Border Width
    private int btnsignUp_corner_radius = 10;                         // Border Corner radius
    private int btnsignUp_textColor = R.color.white;                  // text Color
    private int btnsignUp_textSize = 25;                              // text Size
    private int btnsignUp_text = R.string.btn_sign_up;                  // text


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        headerView = (CustomHeaderView) findViewById(R.id.rlt_header);
        edt_register_code = (EmailEditTextView) findViewById(R.id.edt_register_code);
        edt_email_field = (RelativeLayout) findViewById(R.id.layout_register_code);
        edt_name = (EmailEditTextView) findViewById(R.id.edt_name);
        edt_name_field = (RelativeLayout) findViewById(R.id.name_field);
        edt_user_name = (EmailEditTextView) findViewById(R.id.edt_user_name);
        edt_user_name_field = (RelativeLayout) findViewById(R.id.user_name_field);
        edtemail = (EmailEditTextView) findViewById(R.id.edt_email);
        edtemail_field = (RelativeLayout) findViewById(R.id.email_field);
        edt_password=(PasswordEditTextView)  findViewById(R.id.password);
        edt_password_field = (RelativeLayout) findViewById(R.id.password_field);
        edt_phone=(EmailEditTextView)  findViewById(R.id.edt_phone);
        edt_phone_field= (RelativeLayout) findViewById(R.id.phone);
        edt_birthday=(EmailEditTextView)  findViewById(R.id.edt_birthday);
        edt_birthday_field= (RelativeLayout) findViewById(R.id.birthday);

        btnSignUp=(CustomSubmitButton)  findViewById(R.id.btn_sign_up);


        headerView.setHeaderItemClickListener(new HeaderItemClickListener() {
            @Override
            public void onLeftItemClick() {
                finish();
               // Toast.makeText(SignupActivity.this, "left Clicked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRightItemClick() {
                Toast.makeText(SignupActivity.this, "right Clicked", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onTitleClick() {
                Toast.makeText(SignupActivity.this, "title Clicked", Toast.LENGTH_LONG).show();

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

        //setUp email edittext edt_register_code

        setEmailFieldVisibility(edtFieldAdd);
        setedtEmailVisibility(edtAdd);
        enableedtEmailHint(edt_emailHintAdd);
        edt_register_code.setCursor_color(this.getResources().getColor(edt_emailCursorColor));
        edt_register_code.setBackgroundColor(this.getResources().getColor(edt_email_background_color));
        edt_register_code.setBorderColor(this.getResources().getColor(edt_email_border_color));
        edt_register_code.setBorderWidth(edt_email_border_width);
        edt_register_code.setTextProperties(this.getResources().getColor(edt_email_textColor), edt_email_textSize);
        edt_register_code.setBorderRadius(edt_email_corner_radius, this.getResources().getColor(edt_email_border_color), edt_email_border_width);
        edt_register_code.setLines(lines);
        edt_register_code.setMaxLines(max_lines);
        edt_register_code.resizeTextField(this);


        //setUp name edittext

        setNameFieldVisibility(edtNameFieldAdd);
        setedtNameVisibility(edtNameAdd);
        enableedtNameHint(edt_nameHintAdd);
        edt_name.setCursor_color(this.getResources().getColor(edt_nameCursorColor));
        edt_name.setBackgroundColor(this.getResources().getColor(edt_name_background_color));
        edt_name.setBorderColor(this.getResources().getColor(edt_name_border_color));
        edt_name.setBorderWidth(edt_name_border_width);
        edt_name.setTextProperties(this.getResources().getColor(edt_name_textColor), edt_name_textSize);
        edt_name.setBorderRadius(edt_name_corner_radius, this.getResources().getColor(edt_name_border_color), edt_name_border_width);
        edt_name.setLines(name_lines);
        edt_name.setMaxLines(name_max_lines);
        edt_name.resizeTextField(this);


        //setUp username edittext

        setUserNameFieldVisibility(edtUserNameFieldAdd);
        setedtUserNameVisibility(edtUserNameAdd);
        enableedtUserNameHint(edt_user_nameHintAdd);
        edt_user_name.setCursor_color(this.getResources().getColor(edt_user_nameCursorColor));
        edt_user_name.setBackgroundColor(this.getResources().getColor(edt_user_name_background_color));
        edt_user_name.setBorderColor(this.getResources().getColor(edt_user_name_border_color));
        edt_user_name.setBorderWidth(edt_user_name_border_width);
        edt_user_name.setTextProperties(this.getResources().getColor(edt_user_name_textColor), edt_user_name_textSize);
        edt_user_name.setBorderRadius(edt_user_name_corner_radius, this.getResources().getColor(edt_user_name_border_color), edt_user_name_border_width);
        edt_user_name.setLines(user_name_lines);
        edt_user_name.setMaxLines(user_name_max_lines);
        edt_user_name.resizeTextField(this);


        //setup email

        setemailFieldVisibility(edtEmailFieldAdd);
        setEmailVisibility(edtEmailAdd);
        enableEmailHint(edtemailHintAdd);
        edtemail.setCursor_color(this.getResources().getColor(edtemailCursorColor));
        edtemail.setBackgroundColor(this.getResources().getColor(email_background_color));
        edtemail.setBorderColor(this.getResources().getColor(email_background_color));
        edtemail.setBorderWidth(email_border_width);
        edtemail.setTextProperties(this.getResources().getColor(email_textColor), email_textSize);
        edtemail.setBorderRadius(email_corner_radius, this.getResources().getColor(email_border_color), email_border_width);
        edtemail.setLines(email_lines);
        edtemail.setMaxLines(email_max_lines);
        edtemail.resizeTextField(this);


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




        //setUp  phone

        setPhoneFieldVisibility(edtPhoneFieldAdd);
        setedtPhoneVisibility(edtPhoneAdd);
        enableedtPhoneHint(edt_phoneHintAdd);
        edt_phone.setCursor_color(this.getResources().getColor(edt_phoneCursorColor));
        edt_phone.setBackgroundColor(this.getResources().getColor(edt_phone_background_color));
        edt_phone.setBorderColor(this.getResources().getColor(edt_phone_border_color));
        edt_phone.setBorderWidth(edt_phone_border_width);
        edt_phone.setTextProperties(this.getResources().getColor(edt_phone_textColor), edt_phone_textSize);
        edt_phone.setBorderRadius(edt_phone_corner_radius, this.getResources().getColor(edt_phone_border_color), edt_phone_border_width);
        edt_phone.setLines(phone_lines);
        edt_phone.setMaxLines(phone_max_lines);
        edt_phone.resizeTextField(this);



        //setUp birthday

        setBirthdayFieldVisibility(edtBirthdayAdd);
        setedtBirthdayVisibility(edt_birthdayAdd);
        enableedtBirthdayHint(edtbirthdayHintAdd);
        edt_birthday.setCursor_color(this.getResources().getColor(edt_birthdayCursorColor));
        edt_birthday.setBackgroundColor(this.getResources().getColor(edt_birthday_background_color));
        edt_birthday.setBorderColor(this.getResources().getColor(edt_birthday_border_color));
        edt_birthday.setBorderWidth(edt_birthday_border_width);
        edt_birthday.setTextProperties(this.getResources().getColor(edt_birthday_textColor), edt_birthday_textSize);
        edt_birthday.setBorderRadius(edt_birthday_corner_radius, this.getResources().getColor(edt_birthday_border_color), edt_birthday_border_width);
        edt_birthday.setLines(lines);
        edt_birthday.setMaxLines(max_lines);
        edt_birthday.resizeTextField(this);




        //Set up custom sighn Up button
        setbtnSignUpVisibility(btnsignUpAdd);
        btnSignUp.setBorderRadius(this.getResources().getColor(btnsignUp_background_color),btnsignUp_corner_radius,this.getResources().getColor(btnsignUp_border_color),btnsignUp_border_width);
        btnSignUp.setText(this.getResources().getString(btnsignUp_text));
        btnSignUp.setTextColor(this.getResources().getColor(btnsignUp_textColor));
        btnSignUp.setTextSize(btnsignUp_textSize);
        btnSignUp.setTag(String.valueOf(btnsignUp_textSize));






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


    private void setbtnSignUpVisibility(boolean visible) {
        if (visible)
            btnSignUp.setVisibility(View.VISIBLE);
        else
            btnSignUp.setVisibility(View.GONE);
    }

    private void setedtEmailVisibility(boolean visible) {
        if (visible)
            edt_register_code.setVisibility(View.VISIBLE);
        else
            edt_register_code.setVisibility(View.GONE);
    }


    private void setBirthdayFieldVisibility(boolean visible) {
        if (visible)
            edt_birthday_field.setVisibility(View.VISIBLE);
        else
            edt_birthday_field.setVisibility(View.GONE);
    }

    private void setedtBirthdayVisibility(boolean visible) {
        if (visible)
            edt_birthday.setVisibility(View.VISIBLE);
        else
            edt_birthday.setVisibility(View.GONE);
    }



    private void setPhoneFieldVisibility(boolean visible) {
        if (visible)
            edt_phone_field.setVisibility(View.VISIBLE);
        else
            edt_phone_field.setVisibility(View.GONE);
    }


    private void setedtPhoneVisibility(boolean visible) {
        if (visible)
            edt_phone.setVisibility(View.VISIBLE);
        else
            edt_phone.setVisibility(View.GONE);
    }


    private void setemailFieldVisibility(boolean visible) {
        if (visible)
            edtemail_field.setVisibility(View.VISIBLE);
        else
            edtemail_field.setVisibility(View.GONE);
    }

    private void setEmailVisibility(boolean visible) {
        if (visible)
            edtemail.setVisibility(View.VISIBLE);
        else
            edtemail.setVisibility(View.GONE);
    }


    private void enableEmailHint(boolean visible) {
        if (visible)
            edtemail.setHint(edtemailHint, this.getResources().getColor(edtemailHintColor));
        else
            edtemail.setHint("", this.getResources().getColor(edtemailHintColor));
    }


    private void enableedtEmailHint(boolean visible) {
        if (visible)
            edt_register_code.setHint(edt_emailHint, this.getResources().getColor(edt_emailHintColor));
        else
            edt_register_code.setHint("", this.getResources().getColor(edt_emailHintColor));
    }


    private void enableedtNameHint(boolean visible) {
        if (visible)
            edt_name.setHint(edt_nameHint, this.getResources().getColor(edt_nameHintColor));
        else
            edt_name.setHint("", this.getResources().getColor(edt_nameHintColor));
    }


    private void enableedtBirthdayHint(boolean visible) {
        if (visible)
            edt_birthday.setHint(edt_birthdayHint, this.getResources().getColor(edt_birthdayHintColor));
        else
            edt_birthday.setHint("", this.getResources().getColor(edt_birthdayHintColor));
    }

    private void enableedtUserNameHint(boolean visible) {
        if (visible)
            edt_register_code.setHint(edt_user_nameHint, this.getResources().getColor(edt_emailHintColor));
        else
            edt_register_code.setHint("", this.getResources().getColor(edt_emailHintColor));
    }

    private void enableedtPhoneHint(boolean visible) {
        if (visible)
            edt_phone.setHint(edt_phoneHint, this.getResources().getColor(edt_phoneHintColor));
        else
            edt_phone.setHint("", this.getResources().getColor(edt_phoneHintColor));
    }

    private void enableedtPasswordHint(boolean visible) {
        if (visible)
            edt_password.setHintPassword(edt_passwordHint, this.getResources().getColor(edt_passwordHintColor));
        else
            edt_password.setHintPassword("", this.getResources().getColor(edt_passwordHintColor));
    }






    private void setEmailFieldVisibility(boolean visible) {
        if (visible)
            edt_email_field.setVisibility(View.VISIBLE);
        else
            edt_email_field.setVisibility(View.GONE);
    }


    private void setedtNameVisibility(boolean visible) {
        if (visible)
            edt_name.setVisibility(View.VISIBLE);
        else
            edt_name.setVisibility(View.GONE);
    }






    private void setNameFieldVisibility(boolean visible) {
        if (visible)
            edt_name_field.setVisibility(View.VISIBLE);
        else
            edt_name_field.setVisibility(View.GONE);
    }


    private void setUserNameFieldVisibility(boolean visible) {
        if (visible)
            edt_user_name_field.setVisibility(View.VISIBLE);
        else
            edt_user_name_field.setVisibility(View.GONE);
    }

    private void setedtUserNameVisibility(boolean visible) {
        if (visible)
            edt_user_name.setVisibility(View.VISIBLE);
        else
            edt_user_name.setVisibility(View.GONE);
    }



    private void setedtPasswordVisibility(boolean visible) {
        if (visible)
            edt_password.setVisibility(View.VISIBLE);
        else
            edt_password.setVisibility(View.GONE);
    }


}

