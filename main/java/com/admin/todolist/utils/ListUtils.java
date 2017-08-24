package com.admin.todolist.utils;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class ListUtils {

    public interface Comparator {
        public boolean comparat(int i,int j);

    }
    public static<T> void sort(List<T> list,Comparator comparator) {
        //冒泡排序算法
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (comparator.comparat(i,j)){
                    T t =list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,t);
                }
            }
        }
    }
}
