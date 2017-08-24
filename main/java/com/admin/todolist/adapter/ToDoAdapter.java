package com.admin.todolist.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.admin.todolist.R;
import com.admin.todolist.model.ToDoModel;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */

public class ToDoAdapter extends MyBaseAdapter<ToDoModel,ToDoAdapter.ViewHolder> {


    public ToDoAdapter(Context context, List<ToDoModel> data) {
        super(context, data);
    }

    @Override
    int getLayoutId() {
        return R.layout.item_todo;
    }

    @Override
    ViewHolder getViewHolder(View view, ViewGroup viewGroup) {

         ViewHolder viewHolder = new ViewHolder();
        viewHolder.tv =view.findViewById(R.id.tv_name);
        return viewHolder;
    }

    @Override
    void afterViewHolder(ViewHolder viewHolder, int i) {
           viewHolder.tv.setText(data.get(i).getName());
    }

    class ViewHolder{
        TextView tv;
    }
}
