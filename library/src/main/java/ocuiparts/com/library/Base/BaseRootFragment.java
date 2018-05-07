package ocuiparts.com.library.Base;

import android.support.v4.app.Fragment;

/**
 * Created by Giangnt on 10/04/17.
 */

public abstract class BaseRootFragment extends Fragment {

    @Override
    public void setUserVisibleHint(boolean visible){
        super.setUserVisibleHint(visible);
        if (visible){
            // when this Fragment is active
            sendScreenNameToReproWhenUserVisible();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        sendScreenNameToReproWhenResume();
    }

    private void sendScreenNameToReproWhenUserVisible() {
        String screenName = null;
//        if (this instanceof HomeTimelineFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_TIMELINE;
//        } else if (this instanceof HomePointEarnedFragment) {
//            screenName = ((HomePointEarnedFragment) this).getCurrentReproScreenName();
//        } else if (this instanceof HomePointExchangeFragment) {
//            screenName = ((HomePointExchangeFragment) this).getCurrentReproScreenName();
//        } else if (this instanceof HomeJobFragment) {
//            screenName = ((HomeJobFragment) this).getCurrentReproScreenName();
//        }else if (this instanceof HomeJobIntroductionFragment) {
//            screenName = ((HomeJobIntroductionFragment) this).getCurrentReproScreenName();
//        } else if (this instanceof HomeResidentsNoteFragment) {
//            screenName = ((HomeResidentsNoteFragment) this).getCurrentReproScreenName();
//        }
//
//        if (screenName != null) {
//            Utils.sendScreenNameToRepro(screenName);
//        }
    }

    private void sendScreenNameToReproWhenResume() {
        String screenName = null;
//        if (this instanceof PasswordEmailFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_FORGET_PASSWORD_INPUT_MAIL;
//        } else if (this instanceof PasswordCodeFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_FORGET_PASSWORD_INPUT_CODE;
//        } else if (this instanceof PasswordNewFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_FORGET_PASSWORD_INPUT_NEW_PASSWORD;
//        } else if (this instanceof SkillStep1Fragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_SKILL_CHECK_PAGE_1;
//        } else if (this instanceof SkillStep2Fragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_SKILL_CHECK_PAGE_2;
//        } else if (this instanceof PointDetailFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_POINT_EARN_DETAIL;
//        } else if (this instanceof ExchangeDetailFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_POINT_EXCHANGE_DETAIL;
//        } else if (this instanceof ByteDetailNewFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_BYTE_DETAIL;
//        }else if (this instanceof JobDetailFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_JOB_INTRODUCTION_DETAIL;
//        } else if (this instanceof NoteDetailFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_NOTE_DETAIL;
//        } else if (this instanceof AlertDetailFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_ALERT_DETAIL;
//        } else if (this instanceof MyPageProfileFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_PROFILE_EDIT;
//        } else if (this instanceof MyPageSkillFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_MY_SKILL;
//        } else if (this instanceof TermOfServiceFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_TERM;
//        } else if (this instanceof PrivacyPolicyFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_PRIVACY;
//        } else if (this instanceof FAQScreenFragment) {
//            screenName = Constant.ReproEvent.REPRO_SCREEN_FAQ;
//        }
//
//        if (screenName != null) {
//            Utils.sendScreenNameToRepro(screenName);
//        }
    }
}
