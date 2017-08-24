package com.admin.todolist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.admin.todolist.R;
import com.admin.todolist.adapter.IconsAdapter;

import java.util.ArrayList;
import java.util.List;

public class IconChooseActivity extends AppCompatActivity {

    ListView lvIcons;
    List<Pair<Integer, String>> icons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_choose);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("选择Icon");

        inttData();
        lvIcons = (ListView) findViewById(R.id.lv_icons);
        //为ListView添加一个适配器
        lvIcons.setAdapter(new IconsAdapter(IconChooseActivity.this, icons));

        lvIcons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.putExtra("chosenIconId", icons.get(i).first);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void inttData() {
        icons.add(new Pair<>(R.drawable.christmas_2015_22, "christma"));
        icons.add(new Pair<>(R.drawable.drinks, "drinks"));
        icons.add(new Pair<>(R.drawable.aeroplane3, "aeroplane"));
        icons.add(new Pair<>(R.drawable.alarm17, "alarm"));
        icons.add(new Pair<>(R.drawable.beer10, "beer"));
        icons.add(new Pair<>(R.drawable.download14, "download"));
        icons.add(new Pair<>(R.drawable.folder69, "folder"));
        icons.add(new Pair<>(R.drawable.photo193, "photo"));
    }
}
