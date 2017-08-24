package com.admin.todolist.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.admin.todolist.R;

public class AddGroupActivity extends AppCompatActivity {

    public static final int REQUESTCODE_CHOOSE_ICON=1000;

    ImageView ivChosenIcon;
    int chosenIconId;
    EditText etGroupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("添加分组");
        setSupportActionBar(toolbar);

        ivChosenIcon = (ImageView) findViewById(R.id.iv_chosen);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_icon_choose);
        relativeLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddGroupActivity.this,IconChooseActivity.class);
               startActivityForResult(intent,REQUESTCODE_CHOOSE_ICON);
            }
        });
        etGroupName = (EditText) findViewById(R.id.et_group_name);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUESTCODE_CHOOSE_ICON) {

            if(resultCode == RESULT_OK){
                chosenIconId = data.getIntExtra("chosenIconId",-1);
                ivChosenIcon.setImageResource(chosenIconId);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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
                String groupName = etGroupName.getText().toString().trim();
                if(groupName == null || "".equals(groupName)){
                    Toast.makeText(AddGroupActivity.this,"请输入分组名",Toast.LENGTH_SHORT).show();
                    return true;
                }
                saveGroup(groupName);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveGroup(String groupName) {
        SharedPreferences  sharedPreferences = getSharedPreferences("groups",MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putInt(groupName,chosenIconId);
        editor.commit();
    }
}
