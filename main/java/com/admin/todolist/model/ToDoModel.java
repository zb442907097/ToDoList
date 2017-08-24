package com.admin.todolist.model;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class ToDoModel {

    private long createTime;
    private boolean needModify;
    private String notifyTime;
    private String name;

    @Override
    public String toString() {

        return needModify+"&"+notifyTime+"&"+createTime;
    }

    public ToDoModel(String name, String notifyTime, boolean needModify , long createTime ) {
        this.createTime = createTime;
        this.needModify = needModify;
        this.notifyTime = notifyTime;
        this.name = name;
    }

    public ToDoModel(Map.Entry<String,String> entry){
        this.name =entry.getKey();
        String value= entry.getValue();
        String[] fields =value.split("&");

        this.needModify =Boolean.parseBoolean(fields[0]);
        this.notifyTime =fields[1];
        this.createTime =Long.parseLong(fields[2]);

    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isNeedModify() {
        return needModify;
    }

    public void setNeedModify(boolean needModify) {
        this.needModify = needModify;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
