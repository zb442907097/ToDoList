package com.admin.todolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.admin.todolist.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/21.
 */

public class GroupAdapter extends MyBaseAdapter<Map.Entry<String,Integer>,GroupAdapter.ViewHolder>{


    public GroupAdapter(Context context, List<Map.Entry<String, Integer>> data) {
        super(context, data);
    }

    @Override
    int getLayoutId() {
        return R.layout.item_icon_choose;
    }

    @Override
    ViewHolder getViewHolder(View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.ivIcon =(ImageView) view.findViewById(R.id.iv_icon);
        viewHolder.tvName = (TextView) view.findViewById(R.id.tv_name);
        return viewHolder;
    }

    @Override
    void afterViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.ivIcon.setImageResource(data.get(i).getValue());
        viewHolder.tvName.setText(data.get(i).getKey());
    }

    class ViewHolder {
        ImageView ivIcon;
        TextView tvName;
    }
}
