package com.admin.todolist.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.admin.todolist.R;
import com.admin.todolist.adapter.GroupAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ListView lvGroups;
    List<Map.Entry<String,Integer>> groups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("分组列表");
        setSupportActionBar(toolbar);

        lvGroups = (ListView) findViewById(R.id.lv_groups);

        lvGroups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String groupName = groups.get(i).getKey();
                    Intent intent =new Intent(MainActivity.this,ToDoListActivity.class);
                intent.putExtra("groupName",groupName);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("groups",MODE_PRIVATE);
        Map<String,Integer> map = (Map<String, Integer>) sharedPreferences.getAll();
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        groups = new ArrayList<>(set);

        lvGroups.setAdapter(new GroupAdapter(MainActivity.this,groups));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId =item.getItemId();
        switch (itemId){
            case R.id.item_add:
                Intent intent = new Intent(MainActivity.this,AddGroupActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
