package ocuiparts.com.library.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WIN-HAIVM on 6/29/17.
 */

public class TimelineEntity implements Parcelable {
    @SerializedName("id")
    public int id = 5;
    @SerializedName("name")
    public String name = "☆11月イベント 《溶岩ホットヨガ》参加者募集開始☆";

    @SerializedName("description")
    public String description = "<div>寒くなってきたこの時期にぴったり！！<br />\n" +
            "『美しく痩せる』女性に大人気の<br />\n" +
            "ホットヨガイベント開催決定☆<br />\n" +
            "<br />\n" +
            "ご参加ご希望の場合、<br />\n" +
            "以下の【お申込はこちら】よりご応募下さい♪<br />\n" +
            "<br />\n" +
            "～溶岩ホットヨガ～<br />\n" +
            "天然の溶岩プレートを敷き詰めて<br />\n" +
            "床から温めているため遠赤外線効果で<br />\n" +
            "カラダを温めることができます。<br />\n" +
            "ダイエットはもちろん、骨盤調整・美肌・むくみ緩和などの効果が期待できます。<br />\n" +
            "<br />\n" +
            "＝＝＝＝＝<br />\n" +
            "<strong>日時</strong>：11/11（土）<br />\n" +
            "15:20～16:10（レッスン50分間）<br />\n" +
            "※お申込多数の場合上記時間帯に加え、同日16:50～の回にご案内になる可能性もございます。<br />\n" +
            "<br />\n" +
            "<strong>参加費</strong>：会員様無料・非会員様3,000円<br />\n" +
            "<br />\n" +
            "<strong>会場</strong>：Lala Aasha 池袋スタジオ<br />\n" +
            "<br />\n" +
            "<strong>アクセス</strong>：各線　池袋駅東口徒歩3分<br />\n" +
            "<br />\n" +
            "<strong>持ち物</strong>：お水、ウェア上下、替えの下着、衣類を入れる袋　等<br />\n" +
            "<br />\n" +
            "<strong>【お申込はこちら】</strong><br />\n" +
            "https://goo.gl/forms/XNtKgLZ6DHKDjbFK2<br />\n" +
            "<br />\n" +
            "※ご参加には申込が必須です。<br />\n" +
            "※定員に達し次第キャンセル待ちフォームとなります。</div>\n";

    @SerializedName("image_url")
    public String image_url= "http://va12img.ocdev.me/2017/10/25/52ce0f3b3b3a5872c48c72b8f3ab0a44.jpg";

    @SerializedName("point")
    public int point = 0;

    @SerializedName("created")
    public long created = 1521015240;

    @SerializedName("display_end_date")
    public long display_end_date = 1521015240;

    @SerializedName("type")
    public String type;

    public static final String TIMELINE_TYPE_1 = "exchange";
    public static final String TIMELINE_TYPE_2 = "getpoint";


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.image_url);
        dest.writeInt(this.point);
        dest.writeLong(this.created);
        dest.writeLong(this.display_end_date);
        dest.writeString(this.type);
    }

    public TimelineEntity() {
    }

    protected TimelineEntity(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.image_url = in.readString();
        this.point = in.readInt();
        this.created = in.readLong();
        this.display_end_date = in.readLong();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<TimelineEntity> CREATOR = new Parcelable.Creator<TimelineEntity>() {
        @Override
        public TimelineEntity createFromParcel(Parcel source) {
            return new TimelineEntity(source);
        }

        @Override
        public TimelineEntity[] newArray(int size) {
            return new TimelineEntity[size];
        }
    };
}
