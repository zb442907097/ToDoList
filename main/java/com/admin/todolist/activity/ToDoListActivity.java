package com.admin.todolist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.admin.todolist.R;
import com.admin.todolist.model.ToDoModel;
import com.admin.todolist.utils.DataService;
import com.admin.todolist.adapter.ToDoAdapter;

import java.util.List;


public class ToDoListActivity extends AppCompatActivity {

    String groupName;
    ListView lvToDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        groupName = intent.getStringExtra("groupName");

        toolbar.setTitle(groupName);
        setSupportActionBar(toolbar);

        lvToDos = (ListView) findViewById(R.id.lv_todos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.item_add:
                Intent intent = new Intent(ToDoListActivity.this, AddToDoActivity.class);
                intent.putExtra("groupName", groupName);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<ToDoModel> toDoModels = DataService.getToDoModel(ToDoListActivity.this,groupName);

        lvToDos.setAdapter(new ToDoAdapter(ToDoListActivity.this, toDoModels));
    }

}
