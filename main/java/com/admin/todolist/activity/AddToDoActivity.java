package com.admin.todolist.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.admin.todolist.R;
import com.admin.todolist.model.ToDoModel;
import com.admin.todolist.utils.DataService;
import com.admin.todolist.widget.DateAndTimePickerDialog;


public class AddToDoActivity extends AppCompatActivity {

    TextView tvPickedTime;
    EditText edToDoName;
    CheckBox cbNeedNotify;

    String pickedTime;

    String groupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        groupName =getIntent().getStringExtra("groupName");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("添加任务");
        setSupportActionBar(toolbar);

        findViewById(R.id.rl_time_picker).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pickDateAndTime();
            }
        });
        tvPickedTime = (TextView) findViewById(R.id.tv_picked_time);
        edToDoName = (EditText) findViewById(R.id.et_todo_name);
        cbNeedNotify = (CheckBox) findViewById(R.id.cb_need_notify);
    }

    private void pickDateAndTime() {
        DateAndTimePickerDialog.showDateAndTimePickerDialog(AddToDoActivity.this,
                new DateAndTimePickerDialog.OnDateAndTimePickedListener(){

                    @Override
                    public void OnDateAndTimePicked(String p) {
                        pickedTime =p;
                        tvPickedTime.setText(pickedTime);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_confirm,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.item_confirm:
                savaToDo();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void savaToDo() {
        String toDoName =edToDoName.getText().toString().trim();
        if(toDoName ==null || "".equals(toDoName)){
            Toast.makeText(AddToDoActivity.this,"请输入任务名",Toast.LENGTH_SHORT).show();
            return;
        }
        boolean needNotify =cbNeedNotify.isChecked();
        DataService.savaToDo(AddToDoActivity.this,groupName
                ,new ToDoModel(toDoName,pickedTime,needNotify,
                        System.currentTimeMillis()));
    }
}


