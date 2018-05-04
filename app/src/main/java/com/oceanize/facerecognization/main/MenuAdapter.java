package com.oceanize.facerecognization.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.oceanize.facerecognization.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 3/2/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder >
{

   public  List<String>  title;
    private Context context;
    OnItemListener onItemListener;
    public MenuAdapter(Context context,
                       List<String>  title, OnItemListener onItemListener)
    {
        this.title = title;
        this.context = context;
        this.onItemListener = onItemListener;
    }


    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.menu_item, null);

        //layoutView.getLayoutParams().width = getScreenWidth() /3;
//        layoutView.getLayoutParams().width = getScreenWidth() / 3;

        //layoutView.getLayoutParams().width = (int) (getScreenWidth() / 3); //
        MenuAdapter.ViewHolder rcv = new MenuAdapter.ViewHolder(layoutView);
        return rcv;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, final int position)
    {
      final ViewHolder holder=(ViewHolder)holder1;
        holder.title.setText(""+title.get(position));
//
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemListener.ItemPosition(position,title.get(position)+"",2);

            }
        });


    }

    @Override
    public int getItemCount()
    {
        return this.title.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;

        public ViewHolder(View itemView)
        {
            super(itemView);


            title = (TextView) itemView.findViewById(R.id.title);

        }

    }
}