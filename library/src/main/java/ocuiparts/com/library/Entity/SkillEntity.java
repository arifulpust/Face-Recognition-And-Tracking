package ocuiparts.com.library.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


/**
 * Created by WIN-HAIVM on 6/29/17.
 */

public class SkillEntity implements Parcelable {

    // TEMP : check what is entity value : 0 or 1 or .....
    public static final String SKILL_A = "a";
    public static final String SKILL_B = "b";
    public static final String SKILL_C = "c";
    public static final String SKILL_1 = "1";
    public static final String SKILL_0 = "0";
    public static final int TYPE_ABC = 1;
    public static final int TYPE_YES_NO = 2;
    public static final int VAL_1 = 1;
    public static final int VAL_2 = 2;
    public static final int VAL_3 = 3;


    @SerializedName("id")
    public int id;

    @SerializedName("skill_group_id")
    public int skill_group_id = -1;

    @SerializedName("name")
    public String name;

    @SerializedName("value_type")
    public int value_type;

    @SerializedName("skill_group_name")
    public String skill_group_name;

    @SerializedName("skill_group_setting_page")
    public int skill_group_setting_page;

    @SerializedName("skill_group_mypage_page")
    public int skill_group_mypage_page;

    @SerializedName("skill_value")
    public String skill_value;

    public boolean is_dummy_entity = false;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.skill_group_id);
        dest.writeString(this.name);
        dest.writeInt(this.value_type);
        dest.writeString(this.skill_group_name);
        dest.writeInt(this.skill_group_setting_page);
        dest.writeInt(this.skill_group_mypage_page);
        dest.writeString(this.skill_value);
        dest.writeByte(this.is_dummy_entity ? (byte) 1 : (byte) 0);
    }

    public SkillEntity() {
    }

    protected SkillEntity(Parcel in) {
        this.id = in.readInt();
        this.skill_group_id = in.readInt();
        this.name = in.readString();
        this.value_type = in.readInt();
        this.skill_group_name = in.readString();
        this.skill_group_setting_page = in.readInt();
        this.skill_group_mypage_page = in.readInt();
        this.skill_value = in.readString();
        this.is_dummy_entity = in.readByte() != 0;
    }

    public static final Creator<SkillEntity> CREATOR = new Creator<SkillEntity>() {
        @Override
        public SkillEntity createFromParcel(Parcel source) {
            return new SkillEntity(source);
        }

        @Override
        public SkillEntity[] newArray(int size) {
            return new SkillEntity[size];
        }
    };
}
