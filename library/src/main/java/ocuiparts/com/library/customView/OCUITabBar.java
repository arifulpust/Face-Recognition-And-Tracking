package ocuiparts.com.library.customView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ogaclejapan.arclayout.ArcLayout;

import java.util.ArrayList;
import java.util.List;

import ocuiparts.com.library.Interface.OnTabBarItemClickListener;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.customButtons.CustomSubmitButton;

/**
 * Created by mdmunirhossain on 4/20/18.
 */

public class OCUITabBar extends RelativeLayout {
    public CustomSubmitButton btn_footer_center_chat;
    private boolean mIsChatMenuAnimate = false;
    private RelativeLayout rl_menu_layout;
    public RelativeLayout rl_arc_layout;
    public ArcLayout arc_layout;
    public View v_arc_background;
    public View view_rotate_pink;
    public View view_rotate_white;
    public View rlt_rotate_container_selected;
    public View rlt_rotate_container_unselected;
    private static final int SHOW_HIDE_MENU_CHAT_TIME = 500;
    private Context mContext = null;
    private TextView txt_chat_title;
    private OnTabBarItemClickListener onTabBarItemClickListener;

    //footer Button Views
    private AppCompatImageButton btn_footer_home = null;
    private AppCompatImageButton btn_footer_chat = null;
    private AppCompatImageButton btn_footer_alert = null;
    private AppCompatImageButton btn_footer_mypage = null;

    //Arch menu items view
    private LinearLayout lnl_go_job_consultation = null;
    private LinearLayout ll_go_to_house_chat = null;

    //Customizable attributes
    private int background_color = R.color.transparent;
    private int border_color = R.color.transparent;
    private int border_width = 0;
    private int corner_radius = 0;

    private LinearLayout lnl_footer_parent = null;

    public OCUITabBar(Context context) {
        super(context);
    }

    @SuppressLint("ResourceAsColor")
    public OCUITabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomTabBarView, 0, 0);

        try {
            // get the text and colors specified using the names in attrs.xml
            border_color = a.getColor(R.styleable.CustomTextView_border_color, border_color);
            border_width = a.getDimensionPixelSize(R.styleable.CustomTextView_border_width, border_width);
            corner_radius = a.getDimensionPixelSize(R.styleable.CustomTextView_corner_radius, corner_radius);
            background_color = a.getColor(R.styleable.CustomTextView_background_color, 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.custom_tabbar_layout, this);
        btn_footer_center_chat = (CustomSubmitButton) this.findViewById(R.id.btn_footer_center_chat);
        rl_menu_layout = (RelativeLayout) this.findViewById(R.id.rl_menu_layout);
        rl_arc_layout = (RelativeLayout) this.findViewById(R.id.rl_arc_layout);
        arc_layout = (ArcLayout) this.findViewById(R.id.arc_layout);
        v_arc_background = (View) this.findViewById(R.id.v_arc_background);
        view_rotate_pink = (View) this.findViewById(R.id.view_rotate_pink);
        view_rotate_white = (View) this.findViewById(R.id.view_rotate_white);
        rlt_rotate_container_selected = (View) this.findViewById(R.id.rlt_rotate_container_selected);
        rlt_rotate_container_unselected = (View) this.findViewById(R.id.rlt_rotate_container_unselected);
        txt_chat_title = (TextView) this.findViewById(R.id.txt_chat_title);

        btn_footer_home = (AppCompatImageButton) this.findViewById(R.id.btn_footer_home);
        btn_footer_chat = (AppCompatImageButton) this.findViewById(R.id.btn_footer_chat);
        btn_footer_alert = (AppCompatImageButton) this.findViewById(R.id.btn_footer_alert);
        btn_footer_mypage = (AppCompatImageButton) this.findViewById(R.id.btn_footer_mypage);

        lnl_go_job_consultation = (LinearLayout) this.findViewById(R.id.lnl_go_job_consultation);
        ll_go_to_house_chat = (LinearLayout) this.findViewById(R.id.ll_go_to_house_chat);

        lnl_footer_parent = (LinearLayout) this.findViewById(R.id.lnl_footer_parent);

        /**
         * click events
         * **/

        btn_footer_center_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCenterChatFragment();
            }
        });

        btn_footer_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTabBarItemClickListener != null) {
                    onTabBarItemClickListener.onHomeItemClick();
                }
            }
        });
        btn_footer_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTabBarItemClickListener != null) {
                    onTabBarItemClickListener.onChatItemClick();
                }
            }
        });
        btn_footer_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTabBarItemClickListener != null) {
                    onTabBarItemClickListener.onAlertItemClick();
                }
            }
        });
        btn_footer_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTabBarItemClickListener != null) {
                    onTabBarItemClickListener.onMyPageItemClick();
                }
            }
        });

        lnl_go_job_consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTabBarItemClickListener != null) {
                    onTabBarItemClickListener.onJobConsultationItemClik();
                }
            }
        });
        ll_go_to_house_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTabBarItemClickListener != null) {
                    onTabBarItemClickListener.onHouseChatItemClick();
                }
            }
        });


        //Setup for customizable attributes
        setUpView();

    }
    private void setUpView() {
        if(background_color != 0)
            setBorderRadius(background_color,corner_radius,border_color,border_width);
    }

    public void setBorderRadius(int background_color,int corner_radius_border, int border_color, int border_width) {
        GradientDrawable shape = new GradientDrawable();
        shape.setCornerRadius(corner_radius_border);
        shape.setStroke(border_width, border_color);
        shape.setColor(background_color);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            lnl_footer_parent.setBackground(shape);
        } else {
            lnl_footer_parent.setBackgroundDrawable(shape);
        }

    }

    public OCUITabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OCUITabBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private Animator createShowItemAnimator(View item) {

        int[] pos = new int[2];
        btn_footer_center_chat.getLocationInWindow(pos);
        float dx = pos[0] - item.getX() - item.getWidth() / 2 + btn_footer_center_chat.getWidth() / 2;
        float dy = pos[1] - item.getY() + item.getHeight();// - item.getHeight() + btn_footer_center_chat.getHeight() - CorrectSizeUtil.getValueAfterResize(5);

        item.setTranslationX(dx);
        item.setTranslationY(dy);

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.translationX(dx, 0f),
                AnimatorUtils.translationY(dy, 0f)
        );

        return anim;
    }

    private Animator createHideItemAnimator(final View item) {
        int[] pos = new int[2];
        btn_footer_center_chat.getLocationInWindow(pos);
        float dx = pos[0] - item.getX() - item.getWidth() / 2 + btn_footer_center_chat.getWidth() / 2;
        float dy = pos[1] - item.getY() + item.getHeight();// - item.getHeight() + btn_footer_center_chat.getHeight() - CorrectSizeUtil.getValueAfterResize(5);

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.translationX(0f, dx),
                AnimatorUtils.translationY(0f, dy)
        );

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                item.setTranslationX(0f);
                item.setTranslationY(0f);
            }
        });

        return anim;
    }

    public void showCenterChatFragment() {
        if (mIsChatMenuAnimate) {
            return;
        }
        clickFooter();
    }

    @SuppressWarnings("NewApi")
    private void showMenu() {
        rl_menu_layout.setVisibility(View.VISIBLE);
        rl_menu_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIsChatMenuAnimate = true;
        showHideArcTitle(true);
        showRotateFooter(true);

    }

    private void showRotateFooter(final boolean isOpen) {
        // isOpen : is reverse-clock rotate
        Animation animation;
        rlt_rotate_container_selected.setVisibility(isOpen ? View.VISIBLE : View.GONE);
        rlt_rotate_container_unselected.setVisibility(isOpen ? View.GONE : View.VISIBLE);

        if (rlt_rotate_container_selected.getVisibility() == View.VISIBLE) {
            btn_footer_center_chat.setSelected(true);
        } else {
            btn_footer_center_chat.setSelected(false);
        }

        if (isOpen) {
            animation = new RotateAnimation(45, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        } else {
            animation = new RotateAnimation(45, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }
        animation.setDuration(SHOW_HIDE_MENU_CHAT_TIME);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rlt_rotate_container_selected.setVisibility(View.GONE);
                rlt_rotate_container_unselected.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        if (isOpen) {
            view_rotate_pink.startAnimation(animation);
        } else {
            view_rotate_white.startAnimation(animation);
        }
    }

    private void showHideArcTitle(final boolean isShow) {
        float bottom = 374 * CorrectSizeUtil.getInstance((Activity) mContext).getScreenRateByMultiScreen();
        float top = 0;
        // 374 is txt_chat_title margin bottom
        Animation animation;
        if (isShow) {
            animation = new TranslateAnimation(0, 0, bottom, top);
        } else {
            animation = new TranslateAnimation(0, 0, top, bottom);
        }
        animation.setDuration(SHOW_HIDE_MENU_CHAT_TIME);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isShow) {
                    showHideArcMenu(isShow);
                } else {
                    rl_menu_layout.setVisibility(View.INVISIBLE);
                    rl_menu_layout.setOnClickListener(null);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        txt_chat_title.startAnimation(animation);
    }


    private void showHideArcMenu(boolean isShow) {
        if (isShow) {
            rl_arc_layout.setVisibility(View.VISIBLE);
            List<Animator> animList = new ArrayList<>();

            for (int i = 0, len = arc_layout.getChildCount(); i < len; i++) {
                animList.add(createShowItemAnimator(arc_layout.getChildAt(i)));
            }

            AnimatorSet animSet = new AnimatorSet();
            animSet.setDuration(SHOW_HIDE_MENU_CHAT_TIME);
            animSet.setInterpolator(new OvershootInterpolator());
            animSet.playTogether(animList);
            animSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mIsChatMenuAnimate = false;
                }
            });
            animSet.start();
        } else {
            List<Animator> animList = new ArrayList<>();

            for (int i = arc_layout.getChildCount() - 1; i >= 0; i--) {
                animList.add(createHideItemAnimator(arc_layout.getChildAt(i)));
            }

            final AnimatorSet animSet = new AnimatorSet();
            animSet.setDuration(SHOW_HIDE_MENU_CHAT_TIME);
            animSet.setInterpolator(new AnticipateInterpolator());
            animSet.playTogether(animList);
            animSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mIsChatMenuAnimate = false;
                    //showHideArcBackground(false);
                    rl_arc_layout.setVisibility(View.INVISIBLE);
                    showHideArcTitle(false);
                }
            });
            animSet.start();
        }
    }

    @SuppressWarnings("NewApi")
    private void hideMenu() {
        mIsChatMenuAnimate = true;
        showHideArcMenu(false);
        showRotateFooter(false);
    }

    private void clickFooter() {
        boolean isSelected = !btn_footer_center_chat.isSelected();
        btn_footer_center_chat.setSelected(isSelected);
        showChatMenu(isSelected);
    }

    private void showChatMenu(boolean isShow) {
        if (isShow) {
            showMenu();
        } else {
            hideMenu();
        }
    }

    public void setOnTabBarItemClickListener(OnTabBarItemClickListener listener) {
        this.onTabBarItemClickListener = listener;
    }

    public void toggleArcMenu() {
        btn_footer_center_chat.performClick();
    }

    public boolean isArcMenuOpened() {
        if (btn_footer_center_chat.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
}


class AnimatorUtils {

    public static final String ROTATION = "rotation";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";

    private AnimatorUtils() {
        //No instances.
    }

    public static PropertyValuesHolder rotation(float... values) {
        return PropertyValuesHolder.ofFloat(ROTATION, values);
    }

    public static PropertyValuesHolder translationX(float... values) {
        return PropertyValuesHolder.ofFloat(TRANSLATION_X, values);
    }

    public static PropertyValuesHolder translationY(float... values) {
        return PropertyValuesHolder.ofFloat(TRANSLATION_Y, values);
    }

    public static void startFavoriteAnimation(final View animView, Context context, Animation.AnimationListener listener) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.circular_reveal_animation);
        animation.setAnimationListener(listener);
        if (animView.getVisibility() != View.VISIBLE) {
            animView.setVisibility(View.VISIBLE);
        }
        animView.startAnimation(animation);
    }
}
