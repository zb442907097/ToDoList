package com.admin.todolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.admin.todolist.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */

public abstract  class MyBaseAdapter<T,E> extends BaseAdapter{

    Context context;
    List<T> data;

    public MyBaseAdapter(Context context, List<T> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        E e;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(getLayoutId(), viewGroup, false);
            e = getViewHolder(view, viewGroup);
            view.setTag(e);
        } else {
            e = (E) view.getTag();
        }
        afterViewHolder(e, i);
        return view;
    }

    abstract int getLayoutId() ;

    abstract E getViewHolder(View view, ViewGroup viewGroup);

    abstract void afterViewHolder(E e, int i);
}
