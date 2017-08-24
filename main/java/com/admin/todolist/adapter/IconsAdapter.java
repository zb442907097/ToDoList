package com.admin.todolist.adapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.admin.todolist.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/20.
 */

public class IconsAdapter extends MyBaseAdapter<Pair<Integer,String>,IconsAdapter.ViewHolder>{

    public IconsAdapter(Context context, List<Pair<Integer, String>> data) {
        super(context, data);
    }

    @Override
    int getLayoutId() {
        return R.layout.item_icon_choose;
    }

    @Override
    ViewHolder getViewHolder(View view,ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();

        viewHolder.ivIcon =(ImageView) view.findViewById(R.id.iv_icon);
        viewHolder.tvName = (TextView) view.findViewById(R.id.tv_name);
        return viewHolder;
    }

    @Override
    void afterViewHolder(ViewHolder viewHolder,int i) {
        viewHolder.ivIcon.setImageResource(data.get(i).first);
        viewHolder.tvName.setText(data.get(i).second);
    }

    class ViewHolder{
            ImageView ivIcon;
            TextView tvName;
        }
    }
