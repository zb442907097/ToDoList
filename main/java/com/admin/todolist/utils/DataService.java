package com.admin.todolist.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.admin.todolist.model.ToDoModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class DataService {

    public static List<ToDoModel> getToDoModel(Context context,String groupName) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(groupName, context.MODE_PRIVATE);
        Map<String, String> all = (Map<String, String>) sharedPreferences.getAll();
        Set<Map.Entry<String, String>> entrys = all.entrySet();
        final List<Map.Entry<String, String>> toDos = new ArrayList<>(entrys);
        List<ToDoModel> toDoModels = new ArrayList<>();
        for (Map.Entry<String, String> entry : entrys) {

            toDoModels.add(new ToDoModel(entry));
        }

        Collections.sort(toDoModels, new Comparator<ToDoModel>() {

            @Override
            public int compare(ToDoModel lhs, ToDoModel rhs) {

                return (int) (lhs.getCreateTime() - rhs.getCreateTime());
            }
        });
        return toDoModels;
    }

    public static void savaToDo(Context context,String groupName,ToDoModel toDoModel){
        SharedPreferences sharedPreferences =context.getSharedPreferences(groupName,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(toDoModel.getName(),toDoModel.toString());
        editor.commit();
    }
}
