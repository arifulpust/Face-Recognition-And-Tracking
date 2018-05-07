package ocuiparts.com.library.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ocuiparts.com.library.Entity.TimelineEntity;
import ocuiparts.com.library.Interface.ClickInterface;
import ocuiparts.com.library.Interface.LoadMoreInterface;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.Utils.Utils;
import ocuiparts.com.library.customView.CustomTextView;


/**
 * Created by WIN-HAIVM on 6/29/17.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.MyViewHolder> {
    private ArrayList<TimelineEntity> mList = null;
    private Activity mActivity = null;
    private LoadMoreInterface mLoadMore;
    private ClickInterface mClick = null;

    //Custom txt_date label
    private boolean txt_dateAdd = true;                               //add label password or not
    private int txt_date_background_color = R.color.white;            // Background Color
    private int txt_date_border_color = R.color.black;                // Border Color
    private int txt_date_border_width = 0;                            // Border Width
    private int txt_date_corner_radius = 0;                           // Border Corner radius
    private int txt_date_textColor = R.color.gray_bold;               // text Color
    private int txt_date_textSize = 25;                               // text Size


    //Custom txt_title label
    private boolean txt_titleAdd = true;                               //add label password or not
    private int txt_title_background_color = R.color.white;            // Background Color
    private int txt_title_border_color = R.color.black;                // Border Color
    private int txt_title_border_width = 0;                            // Border Width
    private int txt_title_corner_radius = 0;                           // Border Corner radius
    private int txt_title_textColor = R.color.gray_black;              // text Color
    private int txt_title_textSize = 32;                               // text size

    //Custom txt_content_single_line label
    private boolean txt_content_single_lineAdd = true;                               //add label password or not
    private int txt_content_single_line_background_color = R.color.white;            // Background Color
    private int txt_content_single_line_border_color = R.color.black;                // Border Color
    private int txt_content_single_line_border_width = 0;                            // Border Width
    private int txt_content_single_line_corner_radius = 0;                           // Border Corner radius
    private int txt_content_single_line_textColor = R.color.gray_black;              // text Color
    private int txt_content_single_line_textSize = 28;                               // text size

    //Custom txt_content label
    private boolean txt_contentAdd = true;                               //add label password or not
    private int txt_content_background_color = R.color.white;            // Background Color
    private int txt_content_border_color = R.color.black;                // Border Color
    private int txt_content_border_width = 0;                            // Border Width
    private int txt_content_corner_radius = 0;                           // Border Corner radius
    private int txt_content_textColor = R.color.gray_black;              // text Color
    private int txt_content_textSize = 28;                               // text size

    //Custom txt_go_detail label
    private boolean txt_go_detailAdd = true;                               //add label password or not
    private int txt_go_detail_background_color = R.color.white;            // Background Color
    private int txt_go_detail_border_color = R.color.black;                // Border Color
    private int txt_go_detail_border_width = 0;                            // Border Width
    private int txt_go_detail_corner_radius = 0;                           // Border Corner radius
    private int txt_go_detail_textColor = R.color.black;                   // text Color
    private int txt_go_detail_textSize = 28;                               // text size

    //background color of the whole cell
    private int cell_background = R.color.white;                   // BackGround Color


//    public static final boolean isPresentation = false;

    public TimelineAdapter(Activity activity, ArrayList<TimelineEntity> list, LoadMoreInterface loadMore, ClickInterface click) {
        mList = list;
        mLoadMore = loadMore;
        mActivity = activity;
        mClick = click;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_timeline, null);
        CorrectSizeUtil.getInstance(mActivity).correctSize(v);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        //enable templates
        setVisibility(holder.txt_date,txt_dateAdd);
        holder.txt_date.setBorderRadius(mActivity.getResources().getColor(txt_date_background_color),txt_date_corner_radius,mActivity.getResources().getColor(txt_date_border_color),txt_date_border_width);
        holder.txt_date.setTextProperties(mActivity.getResources().getColor(txt_date_textColor), txt_date_textSize);
        holder.txt_date.resizeTextField(mActivity);

        setVisibility(holder.txt_title,txt_titleAdd);
        holder.txt_title.setBorderRadius(mActivity.getResources().getColor(txt_title_background_color),txt_title_corner_radius,mActivity.getResources().getColor(txt_title_border_color),txt_title_border_width);
        holder.txt_title.setTextProperties(mActivity.getResources().getColor(txt_title_textColor), txt_title_textSize);
        holder.txt_title.resizeTextField(mActivity);

        setVisibility(holder.txt_content_single_line,txt_content_single_lineAdd);
        holder.txt_content_single_line.setBorderRadius(mActivity.getResources().getColor(txt_content_single_line_background_color),txt_content_single_line_corner_radius,mActivity.getResources().getColor(txt_content_single_line_border_color),txt_content_single_line_border_width);
        holder.txt_content_single_line.setTextProperties(mActivity.getResources().getColor(txt_content_single_line_textColor), txt_content_single_line_textSize);
        holder.txt_content_single_line.resizeTextField(mActivity);

        setVisibility(holder.txt_content,txt_contentAdd);
        holder.txt_content.setBorderRadius(mActivity.getResources().getColor(txt_content_background_color),txt_content_corner_radius,mActivity.getResources().getColor(txt_content_border_color),txt_content_border_width);
        holder.txt_content.setTextProperties(mActivity.getResources().getColor(txt_content_textColor), txt_content_textSize);
        holder.txt_content.resizeTextField(mActivity);

        setVisibility(holder.txt_go_detail,txt_go_detailAdd);
        holder.txt_go_detail.setBorderRadius(mActivity.getResources().getColor(txt_go_detail_background_color),txt_go_detail_corner_radius,mActivity.getResources().getColor(txt_go_detail_border_color),txt_go_detail_border_width);
        holder.txt_go_detail.setTextProperties(mActivity.getResources().getColor(txt_go_detail_textColor), txt_go_detail_textSize);
        holder.txt_go_detail.resizeTextField(mActivity);

        holder.outer_rl.setBackgroundResource(cell_background);
        holder.inner_ln.setBackgroundResource(cell_background);


//        holder.v_arrow_background.setBackgroundResource(R.drawable.img_to_bottom);
        holder.txt_go_detail.setText(mActivity.getString(R.string.timeline_more));
        final TimelineEntity currentItem = mList.get(position);
        //--------------New design-------------------
        holder.txt_content.setVisibility(View.VISIBLE);
        holder.txt_title.setText(Utils.getStringData(currentItem.name + ""));
        holder.txt_content.setText(Utils.getStringData(currentItem.description + ""));
        holder.txt_content_single_line.setText(Utils.getStringData(currentItem.description));
        holder.txt_content.post(new Runnable() {
            @Override
            public void run() {
                if (holder.txt_content.getLineCount() > 1) {
                    holder.txt_content_single_line.setVisibility(View.VISIBLE);
                    holder.txt_content.setVisibility(View.GONE);
                    holder.lnl_more.setVisibility(View.VISIBLE);
                } else {
                    holder.txt_content_single_line.setVisibility(View.GONE);
                    holder.txt_content.setVisibility(View.VISIBLE);
                    holder.lnl_more.setVisibility(View.GONE);
                }
            }
        });
        holder.txt_date.setText(Utils.getDateFromSecond(currentItem.display_end_date));
//        if (!isPresentation) {
        if (currentItem.image_url != null) {
            holder.lnl_timeline_image.setVisibility(View.VISIBLE);
            Glide.with(mActivity).load(currentItem.image_url).into(holder.img_timeline);
        } else {
            holder.lnl_timeline_image.setVisibility(View.GONE);
        }

//        holder.lnl_more.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (holder.txt_content.getVisibility() == View.VISIBLE) {
//                    holder.txt_content.setVisibility(View.GONE);
//                    holder.txt_content_single_line.setVisibility(View.VISIBLE);
//                    holder.v_arrow_background.setBackgroundResource(R.drawable.img_to_bottom);
//                    holder.txt_go_detail.setText(mActivity.getString(R.string.timeline_more));
//                } else {
//                    holder.txt_content.setVisibility(View.VISIBLE);
//                    holder.txt_content_single_line.setVisibility(View.GONE);
//                    holder.v_arrow_background.setBackgroundResource(R.drawable.img_to_top);
//                    holder.txt_go_detail.setText(mActivity.getString(R.string.timeline_close));
//                }
//            }
//        });

        if (position == mList.size() - 1 && mLoadMore != null) {
            mLoadMore.onLoad();
        } // ignore else

        if (mClick != null) {
            holder.lnl_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClick.onItemClick(position);
                }
            });
        }


    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //---------------------
        public ImageView img_timeline = null;

        public CustomTextView txt_date = null;
        public CustomTextView txt_title = null;
        public CustomTextView txt_content = null;
        public CustomTextView txt_content_single_line = null;
        public CustomTextView txt_go_detail = null;
        public View v_arrow_background;
        public LinearLayout lnl_timeline_image = null;
        public LinearLayout lnl_more = null;
        public LinearLayout lnl_click = null;
        public RelativeLayout outer_rl = null;
        public LinearLayout inner_ln = null;



        public MyViewHolder(View itemView) {
            super(itemView);
            //---------New timeline design------------
            img_timeline = (ImageView) itemView.findViewById(R.id.img_timeline);
            txt_date = (CustomTextView) itemView.findViewById(R.id.txt_date);
            txt_title = (CustomTextView) itemView.findViewById(R.id.txt_title);
            txt_content_single_line = (CustomTextView) itemView.findViewById(R.id.txt_content_single_line);
            txt_content = (CustomTextView) itemView.findViewById(R.id.txt_content);
            txt_go_detail = (CustomTextView) itemView.findViewById(R.id.txt_go_detail);
            v_arrow_background = itemView.findViewById(R.id.v_arrow_background);
            lnl_timeline_image = (LinearLayout) itemView.findViewById(R.id.lnl_timeline_image);
            lnl_more = (LinearLayout) itemView.findViewById(R.id.lnl_more);
            lnl_click = (LinearLayout) itemView.findViewById(R.id.lnl_click);
            outer_rl = (RelativeLayout) itemView.findViewById(R.id.outer_rl);
            inner_ln = (LinearLayout) itemView.findViewById(R.id.inner_ln);

        }
    }

    private void setVisibility(View v,boolean visible){
        if(visible)
            v.setVisibility(View.VISIBLE);
        else
            v.setVisibility(View.GONE);
    }
}
